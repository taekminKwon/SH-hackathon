package com.example.hackathon.account.domain;

import com.example.hackathon.account.domain.shResponse.SHAccountCreationREC;
import com.example.hackathon.account.domain.shResponse.SHAccountREC;

import java.util.List;

public interface AccountService {
    AccountSummaryInfo getAccountSummaryInfo(SHAccountREC externalResponse);

    AccountCreationInfo saveAccount(SHAccountCreationREC externalResponse, String userKey);

    List<AccountSummaryInfo> getAccountSummariesInfo(List<SHAccountREC> externalResponse);

    Account deleteAccount(Long accountId);
}
