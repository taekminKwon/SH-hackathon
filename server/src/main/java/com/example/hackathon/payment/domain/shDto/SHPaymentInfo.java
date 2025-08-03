package com.example.hackathon.payment.domain.shDto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SHPaymentInfo {
    private Long transactionUniqueNo;
    private String accountNo;
    private String transactionDate;
    private String transactionType;
    private String transactionTypeName;
    private String transactionAccountNo;
}
