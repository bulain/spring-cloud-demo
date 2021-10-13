package com.bulain.main.biz;

import com.bulain.main.db1.service.Db1OrderService;
import com.bulain.main.db2.service.Db2OrderService;
import com.bulain.main.pojo.Order;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderBizImpl implements OrderBiz {
    @Autowired
    private Db1OrderService db1OrderService;
    @Autowired
    private Db2OrderService db2OrderService;

    @Override
    @GlobalTransactional
    public void save(Order entity) {

        db1OrderService.save(entity);
        db2OrderService.save(entity);

    }

}
