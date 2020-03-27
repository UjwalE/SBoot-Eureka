package com.shoppin.order.app.controller;

import com.shoppin.order.app.entity.Order;
import com.shoppin.order.app.entity.Payment;
import com.shoppin.order.app.entity.PaymentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Order getOrder(){
        Order result = new Order();
        result.setAmount(1000);
        result.setCustomerId(123);
        result.setDate("12/12/2020");

        PaymentDTO ptmReq = new PaymentDTO();
        ptmReq.setAmt(1000);
        Payment payment = restTemplate.postForObject("http://payment-app/makePayment",ptmReq, Payment.class);
        result.setPaymentId(payment.getPaymentId());
        result.setId(1);
        return  result;
    }
}
