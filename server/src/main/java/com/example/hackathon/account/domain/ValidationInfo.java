package com.example.hackathon.account.domain;

import com.example.hackathon.account.domain.shResponse.SHAccountCreateValidationREC;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ValidationInfo {
    private Long transactionUniqueNo;
    private String accountNo;

    public static ValidationInfo of(SHAccountCreateValidationREC rec) {
        ValidationInfo validationInfo = new ValidationInfo();
        validationInfo.transactionUniqueNo = rec.getTransactionUniqueNo();
        validationInfo.accountNo = rec.getAccountNo();
        return validationInfo;
    }
}
