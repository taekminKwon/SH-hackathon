package com.example.hackathon.account.domain;

import com.example.hackathon.account.domain.shResponse.SHAccountCreationREC;
import com.example.hackathon.account.domain.shResponse.SHAccountREC;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountStore accountStore;
    private final AccountReader accountReader;

    @Override
    @Transactional
    public AccountSummaryInfo getAccountSummaryInfo(SHAccountREC externalResponse) {
        return AccountSummaryInfo.of(externalResponse);
    }

    @Override
    public AccountCreationInfo saveAccount(SHAccountCreationREC externalResponse, String userKey) {
        Account saveAccount = accountStore.saveAccount(Account.createAccount(externalResponse, userKey));
        return AccountCreationInfo.of(saveAccount);
    }

    @Override
    public List<AccountSummaryInfo> getAccountSummariesInfo(List<SHAccountREC> externalResponse) {
        return externalResponse.stream()
                .map(AccountSummaryInfo::of)
                .toList();
    }

    @Override
    public Account deleteAccount(Long accountId) {
        return accountStore.saveAccount(accountReader.findById(accountId).deleteAccount());
    }
}
