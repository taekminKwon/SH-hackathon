package com.example.hackathon.account.infrastructure;

import com.example.hackathon.account.domain.*;
import com.example.hackathon.account.domain.shResponse.SHAccountCreationREC;
import com.example.hackathon.account.domain.shResponse.SHAccountDeletionREC;
import com.example.hackathon.account.domain.shResponse.SHAccountREC;
import com.example.hackathon.account.domain.AccountCreationCommand;
import com.example.hackathon.common.shDto.SHApiRECListResponse;
import com.example.hackathon.common.mock.MockApiLoader;
import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.transaction.Transactional;
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
    @Transactional

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

    @Override
    public SHAccountDeletionREC deleteAccountSummary(SHAccountREC shAccountREC, String refundAccountNo, String userKey) {
        if(shAccountREC.getAccountBalance() == 0L) {
            throw new IllegalArgumentException("잔액이 있는 계좌는 금액 반환 계좌번호를 입력해야 합니다.");
        }
        SHApiRECListResponse<SHAccountDeletionREC> deletionAccountREC = mockApiLoader.loadMockResponse("deleteAccountREC", new TypeReference<SHApiRECListResponse<SHAccountDeletionREC>>() {});
        return deletionAccountREC.getResponseBody().get(0);
    }
}
