package com.example.hackathon.account.application;

import com.example.hackathon.account.domain.*;
import com.example.hackathon.account.domain.shResponse.SHAccountCreateValidationREC;
import com.example.hackathon.account.domain.shResponse.SHAccountREC;
import com.example.hackathon.common.shDto.SHApiRECListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountFacade {
    private final AccountService accountService;
    private final SHAccountReaderPort shAccountReaderPort;
    private final SHAccountValidationPort shAccountValidationPort;
    public AccountSummaryInfo getAccountSummaryInfo(AccountSummaryCriteria criteria) {
        SHApiRECListResponse<SHAccountREC> externalResponse = shAccountReaderPort.getAccountSummary(criteria);
        return accountService.getAccountSummaryInfo(externalResponse);
    }

    public ValidationInfo createOneValidation(AccountValidationCommand command) {
        SHApiRECListResponse<SHAccountCreateValidationREC> externalResponse = shAccountValidationPort.createValidation(command);
        return accountService.createValidationDeposit(externalResponse);
    }
}
