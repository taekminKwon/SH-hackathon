package com.example.hackathon.account.domain;

import com.example.hackathon.account.domain.shResponse.SHAccountREC;
import com.example.hackathon.common.shDto.SHApiRECListResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Override
    @Transactional
    public AccountSummaryInfo getAccountSummaryInfo(SHApiRECListResponse<SHAccountREC> externalResponse) {
        return AccountSummaryInfo.of(externalResponse.getResponseBody().get(0));
    }
}
