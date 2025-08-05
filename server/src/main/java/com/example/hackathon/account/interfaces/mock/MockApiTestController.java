package com.example.hackathon.account.interfaces.mock;

import com.example.hackathon.account.domain.AccountHistoryCriteria;
import com.example.hackathon.account.domain.SHAccountReaderPort;
import com.example.hackathon.account.domain.AccountSummaryCriteria;
import com.example.hackathon.account.domain.shResponse.SHAccountREC;
import com.example.hackathon.account.domain.shResponse.SHTransactionHistoryREC;
import com.example.hackathon.common.shDto.SHApiRECResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class MockApiTestController {
    private final SHAccountReaderPort SHAccountReaderPort;
    @GetMapping("/getAccount")
    public ResponseEntity<SHApiRECResponse<SHAccountREC>> testGetAccount(
            @RequestBody AccountSummaryCriteria criteria
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(SHAccountReaderPort.getAccountSummary(criteria));
    }

    @GetMapping("/getHistories")
    public ResponseEntity<SHApiRECResponse<SHTransactionHistoryREC>> testGetHistory(
            @RequestBody AccountHistoryCriteria criteria
        ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(SHAccountReaderPort.getAccountTransactionHistory(criteria));
    }
}
