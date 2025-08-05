package com.example.hackathon.account.domain;

import com.example.hackathon.account.domain.shResponse.SHAccountCreateValidationREC;
import com.example.hackathon.common.shDto.SHApiRECSingleResponse;

public interface SHAccountValidationPort {
    SHApiRECSingleResponse<SHAccountCreateValidationREC> createValidation(AccountValidationCommand command);
}
