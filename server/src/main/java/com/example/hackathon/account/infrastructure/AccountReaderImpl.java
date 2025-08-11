package com.example.hackathon.account.infrastructure;

import com.example.hackathon.account.domain.Account;
import com.example.hackathon.account.domain.AccountReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AccountReaderImpl implements AccountReader {
    private final AccountRepository accountRepository;
    @Override
    public Account findById(Long accountId) {
        return accountRepository.findByAccountIdAndStatus(accountId, Account.Status.CREATED);
    }
}
