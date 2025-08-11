package com.example.hackathon.account.domain;

import com.example.hackathon.account.domain.shResponse.SHAccountCreationREC;
import com.example.hackathon.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "account")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    private String userId;

    private String bankCode;

    private String accountNo;

    @Enumerated(EnumType.STRING)
    private Status status;

    public static Account createAccount(SHAccountCreationREC accountSummary, String userId) {
        Account account = new Account();
        account.bankCode = accountSummary.getBankCode();
        account.accountNo = accountSummary.getAccountNo();
        account.userId = userId;
        account.status = Status.CREATED;
        return account;
    }

    public Account deleteAccount() {
        this.status = Status.DELETED;
        return this;
    }

    @RequiredArgsConstructor
    @Getter
    public enum Status {
        CREATED("생성"),
        DELETED("삭제");
        private final String status;
    }
}
