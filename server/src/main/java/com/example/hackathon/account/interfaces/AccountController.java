package com.example.hackathon.account.interfaces;

import com.example.hackathon.account.application.AccountFacade;
import com.example.hackathon.account.domain.AccountSummaryCriteria;
import com.example.hackathon.account.domain.AccountSummaryInfo;
import com.example.hackathon.common.APIResponse;
import com.example.hackathon.common.SuccessCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountFacade accountFacade;
    @PostMapping("/getAccountSummary")
    public ResponseEntity<APIResponse<AccountSummaryInfo>> getAccountSummary(@RequestBody @Valid AccountSummaryCriteria criteria) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(APIResponse.success(SuccessCode.OK ,accountFacade.getAccountSummaryInfo(criteria)));
    }
}
