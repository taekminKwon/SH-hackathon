package com.example.hackathon.account.infrastructure;

import com.example.hackathon.account.domain.*;
import com.example.hackathon.account.domain.shResponse.SHAccountREC;
import com.example.hackathon.account.domain.shResponse.SHTransactionHistory;
import com.example.hackathon.common.shResponse.SHApiRECResponse;
import com.example.hackathon.common.mock.MockApiLoader;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MockSHAccountReaderAdapter implements AccountReaderPort {
    private final MockApiLoader mockApiLoader;
    @Override
    public AccountSummary getAccountSummary(AccountSummaryCriteria criteria) {
        SHApiRECResponse<SHAccountREC> getAccountSummary = mockApiLoader.loadMockResponse("getAccountSummary", new TypeReference<SHApiRECResponse<SHAccountREC>>() {});
        return getAccountSummary.getResponseBody().stream()
                .filter(x -> x.getAccountNo().equals(criteria.getAccountNo()))
                .map(AccountSummary::of)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 계좌를 찾을 수 없습니다."));
    }

    @Override
    public List<SHTransactionHistory> getAccountTransactionHistory(AccountHistoryCriteria criteria) {
        return List.of();
    }
}
