package com.example.hackathon.payment.domain;

public interface PaymentService {
    Payment createPayment(PaymentCommand command);
}
