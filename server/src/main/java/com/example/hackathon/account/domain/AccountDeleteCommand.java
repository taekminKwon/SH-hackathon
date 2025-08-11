package com.example.hackathon.account.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class AccountDeleteCommand {
    private Long id;

    private String refundAccountNo;
}
