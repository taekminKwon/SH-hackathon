package com.example.hackathon.account.domain;

import com.example.hackathon.account.domain.shResponse.SHAccountREC;
import com.example.hackathon.account.domain.shResponse.SHTransactionHistoryREC;

public interface SHAccountReaderPort {
    /**
     * 사용자 ID에 해당하는 계좌 목록을 조회합니다.
     */
    SHAccountREC getAccountSummary(AccountSummaryCriteria criteria);

    /**
     * 계좌 거래 내역 목록을 조회합니다
     */
    SHTransactionHistoryREC getAccountTransactionHistory(AccountHistoryCriteria criteria);
}
