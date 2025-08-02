package com.example.hackathon.account.interfaces.mock;

import com.example.hackathon.common.shResponse.SHApiRECResponse;
import com.example.hackathon.account.domain.AccountReaderPort;
import com.example.hackathon.account.domain.AccountSummaryCriteria;
import com.example.hackathon.account.domain.SHAccountREC;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test/getAccount")
public class MockApiTestController {
    private final AccountReaderPort accountReaderPort;
    @GetMapping
    public ResponseEntity<SHApiRECResponse<SHAccountREC>> testGetAccount(
            @RequestBody AccountSummaryCriteria criteria
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(accountReaderPort.getAccountSummary(criteria));
    }
}
