package com.example.hackathon.account.infrastructure;

import com.example.hackathon.account.domain.*;
import com.example.hackathon.account.domain.shResponse.SHAccountCreationREC;
import com.example.hackathon.account.domain.shResponse.SHAccountREC;
import com.example.hackathon.account.domain.shResponse.SHTransactionHistoryREC;
import com.example.hackathon.account.interfaces.AccountCreationCommand;
import com.example.hackathon.common.shDto.SHApiRECListResponse;
import com.example.hackathon.common.mock.MockApiLoader;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MockSHAccountAdapter implements SHAccountReaderPort, SHAccountStorePort {
    private final MockApiLoader mockApiLoader;
    @Override
    public SHAccountREC getAccountSummary(AccountSummaryCriteria criteria) {
        SHApiRECListResponse<SHAccountREC> getAccountSummary = mockApiLoader.loadMockResponse("getAccountSummary", new TypeReference<SHApiRECListResponse<SHAccountREC>>() {});
        return getAccountSummary.getResponseBody().get(0);
    }

    @Override
    public SHTransactionHistoryREC getAccountTransactionHistory(AccountHistoryCriteria criteria) {
        SHApiRECListResponse<SHTransactionHistoryREC> getTransactionHistory = mockApiLoader.loadMockResponse("getTransactionHistory", new TypeReference<SHApiRECListResponse<SHTransactionHistoryREC>>() {});
        return getTransactionHistory.getResponseBody().get(0);
    }

    @Override
    public List<SHAccountREC> getAccountSummaries(String userKey) {
        SHApiRECListResponse<SHAccountREC> getAccountSummaries = mockApiLoader.loadMockResponse("getAccountSummaries", new TypeReference<SHApiRECListResponse<SHAccountREC>>() {});
        return getAccountSummaries.getResponseBody();
    }

    @Override
    public SHAccountCreationREC createAccountSummary(AccountCreationCommand command) {
        SHApiRECListResponse<SHAccountCreationREC> createAccountREC = mockApiLoader.loadMockResponse("createAccountREC", new TypeReference<SHApiRECListResponse<SHAccountCreationREC>>() {});
        return createAccountREC.getResponseBody().get(0);
    }
}
