package com.example.hackathon.account.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class AccountValidationCommand {
    @NotBlank(message = "계좌번호는 필수 입력값입니다.")
    private String accountNo;
}
