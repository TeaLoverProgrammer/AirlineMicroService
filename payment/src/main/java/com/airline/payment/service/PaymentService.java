package com.airline.payment.service;

import com.airline.payment.model.Payment;
import com.airline.payment.model.PaymentResponse;

public class PaymentService implements PaymentServiceInterface {

    @Override
    public PaymentResponse submitPayment(Payment payment) {

        //hardcoding for simplicity instead of calling payment gateway for processing the request.
        PaymentResponse response = new PaymentResponse();
        response.setPaymentId("PMT10122357");
        response.setMessage("Payment is succcesfully processed");

        return response;
    }

    @Override
    public PaymentResponse cancelPayment(String paymentId) {
        //hardcoding for simplicity instead of calling payment gateway for cancelling the payment.
        PaymentResponse response = new PaymentResponse();
        response.setMessage("Payment is succcesfully processed");

        return response;
    }
}
