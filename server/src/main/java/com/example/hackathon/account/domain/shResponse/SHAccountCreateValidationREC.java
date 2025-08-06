package com.example.hackathon.account.domain.shResponse;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SHAccountCreateValidationREC {
    private Long transactionUniqueNo;
    private String accountNo;
}
