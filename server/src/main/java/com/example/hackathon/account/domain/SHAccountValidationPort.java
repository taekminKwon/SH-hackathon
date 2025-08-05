package com.example.hackathon.account.domain;

import com.example.hackathon.account.domain.shResponse.AccountValidationCommand;
import com.example.hackathon.account.domain.shResponse.SHAccountCreateValidationREC;
import com.example.hackathon.common.shDto.SHApiRECResponse;

public interface SHAccountValidationPort {
    SHApiRECResponse<SHAccountCreateValidationREC> createValidation(AccountValidationCommand command);
}
