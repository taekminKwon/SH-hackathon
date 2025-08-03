package com.example.hackathon.payment.domain.shDto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SHPaymentCommand {
    private String depositAccountNo;
    private Long transactionBalance;
    private String withdrawalAccountNo;
    private String depositTransactionalSummary;
    private String withdrawalTransactionalSummary;
}
