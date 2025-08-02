package com.example.hackathon.account.domain;

import com.example.hackathon.common.shResponse.SHApiRECResponse;

public interface AccountReaderPort {
    /**
     * 사용자 ID에 해당하는 계좌 목록을 조회합니다.
     */
    SHApiRECResponse<SHAccountREC> getAccountSummary(AccountSummaryCriteria criteria);
}
