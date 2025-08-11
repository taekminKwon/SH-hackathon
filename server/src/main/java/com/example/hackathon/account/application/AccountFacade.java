package com.example.hackathon.account.application;

import com.example.hackathon.account.domain.*;
import com.example.hackathon.account.domain.shResponse.SHAccountCreationREC;
import com.example.hackathon.account.domain.shResponse.SHAccountDeletionREC;
import com.example.hackathon.account.domain.shResponse.SHAccountREC;
import com.example.hackathon.account.domain.AccountCreationCommand;
import com.example.hackathon.account.domain.AccountCreationInfo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

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
        //TODO 시큐리티 구현 시 수정
        String userKey = "user";
        return accountService.saveAccount(accountSummary, userKey);
    }

    public List<AccountSummaryInfo> getAccountSummariesInfo() {
        //TODO 시큐리티 구현 시 수정
        String userKey = "user";
        List<SHAccountREC> externalResponse = shAccountReaderPort.getAccountSummaries(userKey);
        return accountService.getAccountSummariesInfo(externalResponse);
    }

    @Transactional
    public DeletedAccountInfo deleteAccount(AccountDeleteCommand command) {
        Account account = accountService.deleteAccount(command.getId());
        //TODO 시큐리티 구현 시 수정
        String userKey = "user";
        SHAccountREC accountSummary = shAccountReaderPort.getAccountSummary(AccountSummaryCriteria.of(account));
        SHAccountDeletionREC shAccountDeletionREC = shAccountStorePort.deleteAccountSummary(accountSummary, command.getRefundAccountNo(), userKey);
        return DeletedAccountInfo.of(shAccountDeletionREC);
    }
}
