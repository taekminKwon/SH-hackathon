package com.example.hackathon.account.domain;

import com.example.hackathon.account.domain.shResponse.SHAccountREC;
import com.example.hackathon.account.interfaces.AccountCreationInfo;

import java.util.List;

public interface AccountService {
    AccountSummaryInfo getAccountSummaryInfo(SHAccountREC externalResponse);

    AccountCreationInfo saveAccount(Account user);

    List<AccountSummaryInfo> getAccountSummariesInfo(List<SHAccountREC> externalResponse);
}
