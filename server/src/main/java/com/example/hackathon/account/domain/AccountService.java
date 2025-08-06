package com.example.hackathon.account.domain;

import com.example.hackathon.account.domain.shResponse.SHAccountCreateValidationREC;
import com.example.hackathon.account.domain.shResponse.SHAccountREC;
import com.example.hackathon.common.shDto.SHApiRECListResponse;

public interface AccountService {
    AccountSummaryInfo getAccountSummaryInfo(SHApiRECListResponse<SHAccountREC> externalResponse);

    ValidationInfo createValidationDeposit(SHApiRECListResponse<SHAccountCreateValidationREC> externalResponse);
}
