package com.example.hackathon.domain.account;

import com.example.hackathon.common.shResponse.SHApiResponse;

import java.util.List;

public interface AccountReaderPort {
    /**
     * 사용자 ID에 해당하는 계좌 목록을 조회합니다.
     */
    SHApiResponse<List<SHAccountREC>> getAccountSummary(AccountSummaryCriteria criteria);
}
