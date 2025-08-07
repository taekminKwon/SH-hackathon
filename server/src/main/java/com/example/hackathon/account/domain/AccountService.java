package com.example.hackathon.account.domain;

import com.example.hackathon.account.domain.shResponse.SHAccountREC;
import com.example.hackathon.account.interfaces.AccountCreationInfo;

public interface AccountService {
    AccountSummaryInfo getAccountSummaryInfo(SHAccountREC externalResponse);

    AccountCreationInfo saveAccount(Account user);
}
