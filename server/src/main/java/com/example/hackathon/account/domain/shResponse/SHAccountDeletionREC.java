package com.example.hackathon.account.domain.shResponse;

import lombok.Getter;

@Getter
public class SHAccountDeletionREC {
    private String status;

    private String accountNo;

    private String refundAccountNo;

    private Long accountBalance;
}
