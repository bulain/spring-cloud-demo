package com.bulain.main;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@EnableBatchProcessing
@Configuration
public class TaskBatchInit {

	@Bean
	public FlatFileItemReader<TaskPerson> flatFileItemReader() {
		FlatFileItemReader<TaskPerson> reader = new FlatFileItemReader<>();
		reader.setResource(new ClassPathResource("data/sample_data.csv"));
		reader.setLineMapper(new DefaultLineMapper<TaskPerson>() {
			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames(new String[] { "firstName", "lastName" });
					}
				});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<TaskPerson>() {
					{
						setTargetType(TaskPerson.class);
					}
				});
			}
		});
		return reader;
	}

	@Bean
	public JdbcBatchItemWriter<TaskPerson> jdbcBatchItemWriter(DataSource dataSource) {
		JdbcBatchItemWriter<TaskPerson> writer = new JdbcBatchItemWriter<TaskPerson>();
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<TaskPerson>());
		writer.setSql("INSERT INTO TASK_PERSON (FIRST_NAME, LAST_NAME) VALUES (:firstName, :lastName)");
		writer.setDataSource(dataSource);
		return writer;
	}

	@Bean
	public ItemProcessor<TaskPerson, TaskPerson> itemProcessor() {
		return new ItemProcessor<TaskPerson, TaskPerson>() {
			@Override
			public TaskPerson process(TaskPerson item) throws Exception {
				return item;
			}
		};
	}

	@Bean
	public Job importUserJob(JobBuilderFactory jobBuilderFactory,
			JobExecutionListener jobExecutionListener, Step step) {
		return jobBuilderFactory.get("importUserJob")
				.incrementer(new RunIdIncrementer())
				.listener(jobExecutionListener).start(step).build();
	}

	@Bean
	public Step step(StepBuilderFactory stepBuilderFactory,
			ItemProcessor<TaskPerson, TaskPerson> itemProcessor,
			ItemWriter<TaskPerson> jdbcBatchItemWriter,
			ItemReader<TaskPerson> flatFileItemReader) {
		return stepBuilderFactory.get("step").<TaskPerson, TaskPerson> chunk(10)
				.reader(flatFileItemReader).processor(itemProcessor)
				.writer(jdbcBatchItemWriter).build();
	}

}
