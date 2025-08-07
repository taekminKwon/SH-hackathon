package com.example.hackathon.account.application;

import com.example.hackathon.account.domain.*;
import com.example.hackathon.account.domain.shResponse.SHAccountREC;
import com.example.hackathon.common.shDto.SHApiRECListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountFacade {
    private final AccountService accountService;
    private final SHAccountReaderPort shAccountReaderPort;
    public AccountSummaryInfo getAccountSummaryInfo(AccountSummaryCriteria criteria) {
        SHApiRECListResponse<SHAccountREC> externalResponse = shAccountReaderPort.getAccountSummary(criteria);
        return accountService.getAccountSummaryInfo(externalResponse);
    }
}
