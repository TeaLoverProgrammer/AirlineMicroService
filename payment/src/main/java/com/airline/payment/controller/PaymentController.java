package com.airline.payment.controller;

import com.airline.payment.model.Payment;
import com.airline.payment.model.PaymentResponse;
import com.airline.payment.service.PaymentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/airline/payment")
@Validated
public class PaymentController {

    @Autowired
    PaymentServiceInterface paymentService;

    /**
     * Method to pay flight fare for the given customer
     */
    @PostMapping
    PaymentResponse submitPayment(@RequestBody @Validated final Payment payment){
        return paymentService.submitPayment(payment);
    }

    /**
     * Method to cancel payment
     */
    @DeleteMapping(value="{/paymentId}")
    PaymentResponse cancelPayment(@PathVariable("paymentId") String paymentId){
        return paymentService.cancelPayment(paymentId);
    }



}
