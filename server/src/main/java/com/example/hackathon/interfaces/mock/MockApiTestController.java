package com.example.hackathon.interfaces.mock;

import com.example.hackathon.common.shResponse.SHApiResponse;
import com.example.hackathon.domain.account.AccountReaderPort;
import com.example.hackathon.domain.account.AccountSummaryCriteria;
import com.example.hackathon.domain.account.SHAccountREC;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class MockApiTestController {
    private final AccountReaderPort accountReaderPort;
    @GetMapping
    public ResponseEntity<SHApiResponse<List<SHAccountREC>>> testGetAccount(
            @RequestBody AccountSummaryCriteria criteria
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(accountReaderPort.getAccountSummary(criteria));
    }
}
