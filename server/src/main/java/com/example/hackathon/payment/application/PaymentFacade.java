package com.example.hackathon.payment.application;

import com.example.hackathon.payment.domain.PaymentInfo;
import com.example.hackathon.payment.domain.PaymentService;
import com.example.hackathon.payment.domain.SHPaymentPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentFacade {
    private final SHPaymentPort shPaymentPort;
    private final PaymentService paymentService;

    public PaymentInfo makeDepositTransfer() {
        return null;
    }
}
