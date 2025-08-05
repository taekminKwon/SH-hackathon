package com.example.hackathon.account.domain.shResponse;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class AccountValidationCommand {
    private String accountNo;
    private String authText;
}
