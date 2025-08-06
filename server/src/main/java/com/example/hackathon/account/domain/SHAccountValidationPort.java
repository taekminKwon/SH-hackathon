package com.example.hackathon.account.domain;

import com.example.hackathon.account.domain.shResponse.SHAccountCreateValidationREC;
import com.example.hackathon.account.domain.shResponse.SHAccountValidationREC;
import com.example.hackathon.common.shDto.SHApiRECListResponse;

public interface SHAccountValidationPort {
    SHApiRECListResponse<SHAccountCreateValidationREC> createValidation(AccountValidationCommand command);
    SHApiRECListResponse<SHAccountValidationREC> validateValidation(AccountValidationCriteria criteria);
}
