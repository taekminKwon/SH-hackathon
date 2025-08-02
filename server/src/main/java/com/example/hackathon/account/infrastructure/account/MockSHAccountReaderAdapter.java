package com.example.hackathon.account.infrastructure.account;

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
    public SHApiRECResponse<SHAccountREC> getAccountSummary(AccountSummaryCriteria criteria) {
        return mockApiLoader.loadMockResponse("getAccountSummary", new TypeReference<SHApiRECResponse<SHAccountREC>>() {});
    }
}
