package com.airline.payment.service;

import com.airline.payment.model.Payment;
import com.airline.payment.model.PaymentResponse;

public interface PaymentServiceInterface {

    /**
     * Method to pay flight fare for the given customer
     */
    PaymentResponse submitPayment(Payment payment);

    /**
     * Method to cancel payment
     */
    PaymentResponse cancelPayment(String paymentId);
}
