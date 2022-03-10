package com.bulain.main;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "zipkin-order")
public interface ZipkinOrderService {

    @RequestMapping(value = "order/sales", method = RequestMethod.GET)
    String sales();

}
