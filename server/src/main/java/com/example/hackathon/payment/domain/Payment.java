package com.example.hackathon.payment.domain;

import com.example.hackathon.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Payment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    //TODO user entity 생성 시 수정 예정
    private Long studentId;

    //TODO 가맹점 entity 생성 시 수정 예정
    private Long storeId;

    private Long amountWon;

    @Enumerated(value = EnumType.STRING)
    private PaymentStatus paymentStatus;

    public static Payment createPayment(
            Long studentId,
            Long storeId,
            Long amountWon
    ) {
        Payment payment = new Payment();
        payment.paymentId = studentId;
        payment.storeId = storeId;
        payment.amountWon = amountWon;
        payment.paymentStatus = PaymentStatus.CREATED;
        return payment;
    }

    @RequiredArgsConstructor
    @Getter
    public enum PaymentStatus {
        CREATED("결제 완료"),
        CANCELLED("결제 취소");
        private final String description;
    }
}
