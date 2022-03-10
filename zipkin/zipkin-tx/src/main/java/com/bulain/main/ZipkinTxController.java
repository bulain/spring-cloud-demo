package com.bulain.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZipkinTxController {

    @Autowired
    private ZipkinOrderService zipkinOrderService;
    @Autowired
    private ZipkinInvService zipkinInvService;

    @RequestMapping(value = "/phase", method = RequestMethod.GET)
    public ZipkinTx phase() {
        String sales = zipkinOrderService.sales();
        String lot = zipkinInvService.lot();
        
        ZipkinTx data = new ZipkinTx();
        data.setLot(lot);;
        data.setSales(sales);
        
        return data;
    }
    
}
