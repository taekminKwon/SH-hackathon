package com.example.hackathon.domain.account;

import lombok.AllArgsConstructor;
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
}
