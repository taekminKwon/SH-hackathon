package com.example.hackathon.payment.domain.shDto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class SHPaymentInfo {
    private Long transactionUniqueNo;
    private String accountNo;
    private String transactionDate;
    private String transactionType;
    private String transactionTypeName;
    private String transactionAccountNo;

    @Builder
    public SHPaymentInfo(
            Long transactionUniqueNo,
            String accountNo,
            String transactionDate,
            String transactionType,
            String transactionTypeName,
            String transactionAccountNo
    ) {
        this.transactionUniqueNo = transactionUniqueNo;
        this.accountNo = accountNo;
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
        this.transactionTypeName = transactionTypeName;
        this.transactionAccountNo = transactionAccountNo;
    }
}
