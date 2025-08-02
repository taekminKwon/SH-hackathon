package com.example.hackathon.account.infrastructure.account;

import com.example.hackathon.account.domain.AccountSummary;
import com.example.hackathon.common.shResponse.SHApiRECResponse;
import com.example.hackathon.common.mock.MockApiLoader;
import com.example.hackathon.account.domain.AccountReaderPort;
import com.example.hackathon.account.domain.AccountSummaryCriteria;
import com.example.hackathon.account.domain.SHAccountREC;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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
}
