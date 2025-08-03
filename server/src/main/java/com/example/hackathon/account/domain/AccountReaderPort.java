package com.example.hackathon.account.domain;

import com.example.hackathon.account.domain.shResponse.SHAccountREC;
import com.example.hackathon.account.domain.shResponse.SHTransactionHistory;
import com.example.hackathon.common.shResponse.SHApiRECResponse;

import java.util.List;

public interface AccountReaderPort {
    /**
     * 사용자 ID에 해당하는 계좌 목록을 조회합니다.
     */
    SHApiRECResponse<SHAccountREC> getAccountSummary(AccountSummaryCriteria criteria);
    /**
     * 계좌 거래 내역 목록을 조회합니다
     */
    List<SHTransactionHistory> getAccountTransactionHistory(AccountHistoryCriteria criteria);
}
