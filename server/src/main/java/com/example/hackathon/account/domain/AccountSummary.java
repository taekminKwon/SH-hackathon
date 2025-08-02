package com.example.hackathon.account.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class AccountSummary {
        private String bankName;        // "신한은행"
        private String accountNo;       // "110-****-****" (마스킹 처리)
        private String username;        // "홍길동"
        private String accountTypeName;

        @Builder
        public AccountSummary(
                String bankName,
                String accountNo,
                String username,
                String accountTypeName
        ) {
                this.bankName = bankName;
                this.accountNo = accountNo;
                this.username = username;
                this.accountTypeName = accountTypeName;
        }

        public static AccountSummary of(SHAccountREC shAccountREC) {
                AccountSummary accountSummary = new AccountSummary();
                accountSummary.bankName = shAccountREC.getBankName();
                accountSummary.accountNo = shAccountREC.getAccountNo();
                accountSummary.username = shAccountREC.getUserName();
                accountSummary.accountTypeName = shAccountREC.getAccountTypeName();
                return accountSummary;
        }
}
