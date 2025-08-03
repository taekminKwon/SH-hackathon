package com.example.hackathon.account.domain.shResponse;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class SHTransactionHistoryREC {
    private String totalCount;
    private List<SHTransactionHistory> list;
}
