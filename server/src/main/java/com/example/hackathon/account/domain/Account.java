package com.example.hackathon.account.domain;

import com.example.hackathon.common.BaseTimeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID userHashKey;

    private String accountNo;

    public static Account createAccount(
        String userHashKey,
        String accountNo
    ) {
        Account account = new Account();
        account.userHashKey = UUID.fromString(userHashKey);
        account.accountNo = accountNo;
        return account;
    }
}
