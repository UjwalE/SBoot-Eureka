package com.shoppin.payment.app.controller;

import com.shoppin.payment.app.entity.Payment;
import com.shoppin.payment.app.entity.PaymentDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @PostMapping("/makePayment")
    public Payment makePayment(PaymentDTO paymentdto){
        Payment ptm = new Payment();
        ptm.setAmount(paymentdto.getAmt());
        ptm.setPaymentId(123);
        ptm.setSuccess(true);
        return ptm;
    }
}
