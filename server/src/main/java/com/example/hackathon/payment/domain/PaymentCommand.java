package com.example.hackathon.payment.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PaymentCommand {
    private Long studentId;
    private Long storeId;
    private Long depositAccountId;
    private Long transactionBalance;
    private Long withdrawalAccountId;
    private String depositTransactionSummary;
    private String withdrawalTransactionSummary;
}
