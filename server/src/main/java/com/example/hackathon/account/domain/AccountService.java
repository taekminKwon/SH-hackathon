package com.example.hackathon.account.domain;

import com.example.hackathon.account.domain.shResponse.SHAccountREC;
import com.example.hackathon.common.shDto.SHApiRECListResponse;

public interface AccountService {
    AccountSummaryInfo getAccountSummaryInfo(SHApiRECListResponse<SHAccountREC> externalResponse);
}
