package com.example.hackathon.account.interfaces.mock;

import com.example.hackathon.account.domain.*;
import com.example.hackathon.account.domain.shResponse.SHAccountCreateValidationREC;
import com.example.hackathon.account.domain.shResponse.SHAccountREC;
import com.example.hackathon.account.domain.shResponse.SHAccountValidationREC;
import com.example.hackathon.account.domain.shResponse.SHTransactionHistoryREC;
import com.example.hackathon.common.shDto.SHApiRECListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class MockApiTestController {
    private final SHAccountReaderPort SHAccountReaderPort;
    private final SHAccountValidationPort SHAccountValidationPort;
    @GetMapping("/getAccount")
    public ResponseEntity<SHApiRECListResponse<SHAccountREC>> testGetAccount(@RequestBody AccountSummaryCriteria criteria) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(SHAccountReaderPort.getAccountSummary(criteria));
    }

    @GetMapping("/getHistories")
    public ResponseEntity<SHApiRECListResponse<SHTransactionHistoryREC>> testGetHistory(@RequestBody AccountHistoryCriteria criteria) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(SHAccountReaderPort.getAccountTransactionHistory(criteria));
    }

    @PostMapping("/createValidation")
    public ResponseEntity<SHApiRECListResponse<SHAccountCreateValidationREC>> testCreateValidation(@RequestBody AccountValidationCommand command){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(SHAccountValidationPort.createValidation(command));
    }

    @PostMapping("/validate")
    public ResponseEntity<SHApiRECListResponse<SHAccountValidationREC>> testValidation(@RequestBody AccountValidationCriteria criteria) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(SHAccountValidationPort.validateValidation(criteria));
    }
}
