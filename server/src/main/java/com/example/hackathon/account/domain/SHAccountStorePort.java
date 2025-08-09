package com.example.hackathon.account.domain;

import com.example.hackathon.account.domain.shResponse.SHAccountCreationREC;

public interface SHAccountStorePort {
    SHAccountCreationREC createAccountSummary(AccountCreationCommand command);
}
