package com.example.hackathon.account.domain;

import com.example.hackathon.account.domain.shResponse.SHAccountREC;
import com.example.hackathon.account.interfaces.AccountCreationInfo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountStore accountStore;

    @Override
    @Transactional
    public AccountSummaryInfo getAccountSummaryInfo(SHAccountREC externalResponse) {
        return AccountSummaryInfo.of(externalResponse);
    }

    @Override
    public AccountCreationInfo saveAccount(Account account) {
        Account saveAccount = accountStore.saveAccount(account);
        return AccountCreationInfo.of(saveAccount);
    }

    @Override
    public List<AccountSummaryInfo> getAccountSummariesInfo(List<SHAccountREC> externalResponse) {
        return externalResponse.stream()
                .map(AccountSummaryInfo::of)
                .toList();
    }
}
