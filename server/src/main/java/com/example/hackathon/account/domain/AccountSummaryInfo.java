package com.example.hackathon.account.domain;

import com.example.hackathon.account.domain.shResponse.SHAccountREC;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class AccountSummaryInfo {
    private String userName;
    private String accountNo;
    private String accountName;
    private String accountTypeName;

    public static AccountSummaryInfo of(SHAccountREC rec) {
        AccountSummaryInfo info = new AccountSummaryInfo();
        info.userName = rec.getUserName();
        info.accountNo  = rec.getAccountNo();
        info.accountName = rec.getAccountName();
        info.accountTypeName = rec.getAccountTypeName();
        return info;
    }
}
