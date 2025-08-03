package com.example.hackathon.account.infrastructure;

import com.example.hackathon.account.domain.*;
import com.example.hackathon.account.domain.shResponse.SHAccountREC;
import com.example.hackathon.account.domain.shResponse.SHTransactionHistoryREC;
import com.example.hackathon.common.shDto.SHApiRECResponse;
import com.example.hackathon.common.mock.MockApiLoader;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MockSHAccountReaderAdapter implements AccountReaderPort {
    private final MockApiLoader mockApiLoader;
    @Override
    public SHApiRECResponse<SHAccountREC> getAccountSummary(AccountSummaryCriteria criteria) {
        return  mockApiLoader.loadMockResponse("getAccountSummary", new TypeReference<SHApiRECResponse<SHAccountREC>>() {});
    }

    @Override
    public SHApiRECResponse<SHTransactionHistoryREC> getAccountTransactionHistory(AccountHistoryCriteria criteria) {
        return mockApiLoader.loadMockResponse("getTransactionHistory", new TypeReference<SHApiRECResponse<SHTransactionHistoryREC>>() {});
    }
}
