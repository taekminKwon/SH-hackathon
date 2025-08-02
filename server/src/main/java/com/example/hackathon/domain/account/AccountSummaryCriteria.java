package com.example.hackathon.domain.account;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class AccountSummaryCriteria {
    private String accountNo;

    @Builder
    public AccountSummaryCriteria(String accountNo) {
        this.accountNo = accountNo;
    }
}
