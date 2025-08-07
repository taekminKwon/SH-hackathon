package com.example.hackathon.account.application;

import com.example.hackathon.account.domain.*;
import com.example.hackathon.account.domain.shResponse.SHAccountCreationREC;
import com.example.hackathon.account.domain.shResponse.SHAccountREC;
import com.example.hackathon.account.interfaces.AccountCreationCommand;
import com.example.hackathon.account.interfaces.AccountCreationInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountFacade {
    private final AccountService accountService;
    private final SHAccountReaderPort shAccountReaderPort;
    private final SHAccountStorePort shAccountStorePort;
    public AccountSummaryInfo getAccountSummaryInfo(AccountSummaryCriteria criteria) {
        SHAccountREC externalResponse = shAccountReaderPort.getAccountSummary(criteria);
        return accountService.getAccountSummaryInfo(externalResponse);
    }

    public AccountCreationInfo saveCreatedAccount(AccountCreationCommand command) {
        SHAccountCreationREC accountSummary = shAccountStorePort.createAccountSummary(command);
        return accountService.saveAccount(Account.of(accountSummary, "user"));
    }
}
