package com.example.hackathon.account.domain.shResponse;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SHAccountCreateValidationREC {
    private String transactionUniqueNo;
    private String authText;
}
