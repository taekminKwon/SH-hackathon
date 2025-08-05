package com.example.hackathon.account.infrastructure;

import com.example.hackathon.account.domain.*;
import com.example.hackathon.account.domain.AccountValidationCommand;
import com.example.hackathon.account.domain.shResponse.SHAccountCreateValidationREC;
import com.example.hackathon.account.domain.shResponse.SHAccountREC;
import com.example.hackathon.account.domain.shResponse.SHAccountValidationREC;
import com.example.hackathon.account.domain.shResponse.SHTransactionHistoryREC;
import com.example.hackathon.common.shDto.SHApiRECListResponse;
import com.example.hackathon.common.mock.MockApiLoader;
import com.example.hackathon.common.shDto.SHApiRECSingleResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MockSHAccountAdapter implements SHAccountReaderPort, SHAccountValidationPort {
    private final MockApiLoader mockApiLoader;
    @Override
    public SHApiRECListResponse<SHAccountREC> getAccountSummary(AccountSummaryCriteria criteria) {
        return  mockApiLoader.loadMockResponse("getAccountSummary", new TypeReference<SHApiRECListResponse<SHAccountREC>>() {});
    }

    @Override
    public SHApiRECListResponse<SHTransactionHistoryREC> getAccountTransactionHistory(AccountHistoryCriteria criteria) {
        return mockApiLoader.loadMockResponse("getTransactionHistory", new TypeReference<SHApiRECListResponse<SHTransactionHistoryREC>>() {});
    }

    @Override
    public SHApiRECSingleResponse<SHAccountCreateValidationREC> createValidation(AccountValidationCommand command) {
        return mockApiLoader.loadMockResponse("createValidation", new TypeReference<SHApiRECSingleResponse<SHAccountCreateValidationREC>>() {});
    }

    @Override
    public SHApiRECSingleResponse<SHAccountValidationREC> validateValidation(AccountValidationCriteria criteria) {
        return mockApiLoader.loadMockResponse("validateValidation", new TypeReference<SHApiRECSingleResponse<SHAccountValidationREC>>() {});
    }
}
