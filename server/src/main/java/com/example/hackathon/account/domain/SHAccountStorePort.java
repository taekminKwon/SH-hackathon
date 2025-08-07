package com.example.hackathon.account.domain;

import com.example.hackathon.account.domain.shResponse.SHAccountCreationREC;
import com.example.hackathon.account.interfaces.AccountCreationCommand;

public interface SHAccountStorePort {
    SHAccountCreationREC createAccountSummary(AccountCreationCommand command);
}
