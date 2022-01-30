package com.bulain.main.db1.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bulain.main.db1.mapper.Db1OrderMapper;
import com.bulain.main.db2.mapper.Db2OrderMapper;
import com.bulain.main.pojo.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

@Service
public class Db1OrderServiceImpl extends ServiceImpl<Db1OrderMapper, Order> implements Db1OrderService {
    
    @Override
    @Transactional(rollbackFor = Exception.class, transactionManager = "db1TransactionManager")
    public boolean save(Order entity) {
        return super.save(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, transactionManager = "db1TransactionManager")
    public boolean saveBatch(Collection<Order> entityList) {
        return super.saveBatch(entityList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, transactionManager = "db1TransactionManager")
    public boolean saveOrUpdateBatch(Collection<Order> entityList) {
        return super.saveOrUpdateBatch(entityList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, transactionManager = "db1TransactionManager")
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, transactionManager = "db1TransactionManager")
    public boolean removeByMap(Map<String, Object> columnMap) {
        return super.removeByMap(columnMap);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, transactionManager = "db1TransactionManager")
    public boolean remove(Wrapper<Order> queryWrapper) {
        return super.remove(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, transactionManager = "db1TransactionManager")
    public boolean removeByIds(Collection<?> idList) {
        return super.removeByIds(idList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, transactionManager = "db1TransactionManager")
    public boolean updateById(Order entity) {
        return super.updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, transactionManager = "db1TransactionManager")
    public boolean update(Wrapper<Order> updateWrapper) {
        return super.update(updateWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, transactionManager = "db1TransactionManager")
    public boolean update(Order entity, Wrapper<Order> updateWrapper) {
        return super.update(entity, updateWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, transactionManager = "db1TransactionManager")
    public boolean updateBatchById(Collection<Order> entityList) {
        return super.updateBatchById(entityList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, transactionManager = "db1TransactionManager")
    public boolean saveOrUpdate(Order entity, Wrapper<Order> updateWrapper) {
        return super.saveOrUpdate(entity, updateWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, transactionManager = "db1TransactionManager")
    public boolean saveBatch(Collection<Order> entityList, int batchSize) {
        return super.saveBatch(entityList, batchSize);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, transactionManager = "db1TransactionManager")
    public boolean saveOrUpdate(Order entity) {
        return super.saveOrUpdate(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, transactionManager = "db1TransactionManager")
    public boolean saveOrUpdateBatch(Collection<Order> entityList, int batchSize) {
        return super.saveOrUpdateBatch(entityList, batchSize);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, transactionManager = "db1TransactionManager")
    public boolean updateBatchById(Collection<Order> entityList, int batchSize) {
        return super.updateBatchById(entityList, batchSize);
    }

}
