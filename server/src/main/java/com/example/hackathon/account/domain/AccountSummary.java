package com.example.hackathon.account.domain;

import com.example.hackathon.account.domain.shResponse.SHAccountREC;
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
                return AccountSummary.builder()
                        .bankName(shAccountREC.getBankName())
                        .accountNo(shAccountREC.getAccountNo())
                        .username(shAccountREC.getUserName())
                        .accountTypeName(shAccountREC.getAccountTypeName())
                        .build();
        }
}
