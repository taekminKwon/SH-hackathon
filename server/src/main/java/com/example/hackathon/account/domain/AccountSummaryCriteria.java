package com.example.hackathon.account.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class AccountSummaryCriteria {
    @NotBlank(message = "계좌 번호는 필수 입력 값입니다.")
    private String accountNo;
}
