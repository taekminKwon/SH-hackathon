package com.example.hackathon.account.domain;

import com.example.hackathon.account.domain.shResponse.SHAccountCreationREC;
import com.example.hackathon.common.BaseTimeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    private String userId;

    private String bankCode;

    private String accountNo;

    public static Account of(SHAccountCreationREC accountSummary, String userId) {
        Account account = new Account();
        account.bankCode = accountSummary.getBankCode();
        account.accountNo = accountSummary.getAccountNo();
        account.userId = userId;
        return account;
    }
}
