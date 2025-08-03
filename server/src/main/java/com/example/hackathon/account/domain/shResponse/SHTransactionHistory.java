package com.example.hackathon.account.domain.shResponse;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SHTransactionHistory {
    private Long transactionUniqueNo;       // 거래고유번호
    private String transactionDate;         // 거래일자 (yyyyMMdd)
    private String transactionTime;         // 거래시각 (HHmmss)
    private String transactionType;         // 입출금구분 ("1"=입금, "2"=출금)
    private String transactionTypeName;     // 입출금구분명 ("입금", "출금", ...)
    private String transactionAccountNo;    // 거래계좌번호 (nullable)
    private Long transactionBalance;        // 거래금액
    private Long transactionAfterBalance;   // 거래 후 잔액
    private String transactionSummary;      // 거래 요약내용 (nullable)
    private String transactionMemo;         // 거래 메모 (nullable, 가맹점ID 등)

    @Builder
    public SHTransactionHistory(
            Long transactionUniqueNo,
            String transactionDate,
            String transactionTime,
            String transactionType,
            String transactionTypeName,
            String transactionAccountNo,
            Long transactionBalance,
            Long transactionAfterBalance,
            String transactionSummary,
            String transactionMemo
    ) {
        this.transactionUniqueNo = transactionUniqueNo;
        this.transactionDate = transactionDate;
        this.transactionTime = transactionTime;
        this.transactionType = transactionType;
        this.transactionTypeName = transactionTypeName;
        this.transactionAccountNo = transactionAccountNo;
        this.transactionBalance = transactionBalance;
        this.transactionAfterBalance = transactionAfterBalance;
        this.transactionSummary = transactionSummary;
        this.transactionMemo = transactionMemo;
    }
}
