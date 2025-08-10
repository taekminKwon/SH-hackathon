package com.example.hackathon.account.infrastructure;

import com.example.hackathon.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByAccountIdAndStatus(Long accountId, Account.Status status);
}
