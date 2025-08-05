package com.example.hackathon.account.domain.shResponse;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SHAccountValidationREC {
    private String status;
    private String transactionUniqueNo;
    private String accountNo;
}
