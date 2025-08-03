package com.example.hackathon.account.domain.shResponse;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SHAccountREC {
    private String bankCode;
    private String bankName;
    private String userName;
    private String accountNo;
    private String accountName;
    private String accountTypeCode;
    private String accountTypeName;
    private String accountCreatedDate;
    private String accountExpiryDate;
    private Long dailyTransferLimit;
    private Long oneTimeTransferLimit;
    private Long accountBalance;
    private String lastTransactionDate;
    private String currency;
}
