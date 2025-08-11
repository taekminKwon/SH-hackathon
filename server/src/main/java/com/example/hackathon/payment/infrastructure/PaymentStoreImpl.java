package com.example.hackathon.payment.infrastructure;

import com.example.hackathon.payment.domain.Payment;
import com.example.hackathon.payment.domain.PaymentStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentStoreImpl implements PaymentStore {
    private final PaymentRepository paymentRepository;
    @Override
    public Payment store(Payment payment) {
        return paymentRepository.save(payment);
    }
}
