package com.example.hackathon.account.interfaces;

import com.example.hackathon.account.domain.Account;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class AccountCreationInfo {
    private String bankCode;
    private String accountNo;

    public static AccountCreationInfo of(Account saveAccount) {
        AccountCreationInfo accountCreationInfo = new AccountCreationInfo();
        accountCreationInfo.bankCode = saveAccount.getBankCode();
        accountCreationInfo.accountNo = saveAccount.getAccountNo();
        return accountCreationInfo;
    }
}
