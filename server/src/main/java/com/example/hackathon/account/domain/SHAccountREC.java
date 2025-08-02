package com.example.hackathon.account.domain;

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

    @Builder
    public SHAccountREC(
            String bankCode,
            String bankName,
            String userName,
            String accountNo,
            String accountName,
            String accountTypeCode,
            String accountTypeName,
            String accountCreatedDate,
            String accountExpiryDate,
            Long dailyTransferLimit,
            Long oneTimeTransferLimit,
            Long accountBalance,
            String lastTransactionDate,
            String currency
    ) {
        this.bankCode = bankCode;
        this.bankName = bankName;
        this.userName = userName;
        this.accountNo = accountNo;
        this.accountName = accountName;
        this.accountTypeCode = accountTypeCode;
        this.accountTypeName = accountTypeName;
        this.accountCreatedDate = accountCreatedDate;
        this.accountExpiryDate = accountExpiryDate;
        this.dailyTransferLimit = dailyTransferLimit;
        this.oneTimeTransferLimit = oneTimeTransferLimit;
        this.accountBalance = accountBalance;
        this.lastTransactionDate = lastTransactionDate;
        this.currency = currency;
    }
}
