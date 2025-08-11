package com.example.hackathon.account.domain;

public interface AccountReader {
    Account findById(Long accountId);
}
