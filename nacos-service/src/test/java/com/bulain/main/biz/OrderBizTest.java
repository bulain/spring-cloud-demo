package com.bulain.main.biz;

import com.bulain.main.NacosServiceApplication;
import com.bulain.main.pojo.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = NacosServiceApplication.class)
public class OrderBizTest {
    @Autowired
    private OrderBiz orderBiz;

    @Test
    public void testSave() {

        Order order = new Order();
        order.setName("test");
        order.setCustomerId(0L);
        orderBiz.save(order);
        
    }
}
