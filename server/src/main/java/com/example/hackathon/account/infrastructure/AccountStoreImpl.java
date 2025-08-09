package com.example.hackathon.account.infrastructure;

import com.example.hackathon.account.domain.Account;
import com.example.hackathon.account.domain.AccountStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountStoreImpl implements AccountStore {
    private final AccountRepository accountRepository;
    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }
}
