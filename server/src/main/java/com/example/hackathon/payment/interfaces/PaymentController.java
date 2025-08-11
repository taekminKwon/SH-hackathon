package com.example.hackathon.payment.interfaces;

import com.example.hackathon.common.APIResponse;
import com.example.hackathon.common.SuccessCode;
import com.example.hackathon.payment.application.PaymentFacade;
import com.example.hackathon.payment.domain.PaymentInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentFacade paymentFacade;
    @PostMapping
    public ResponseEntity<APIResponse<PaymentInfo>> updateDepositTransfer() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(APIResponse.success(SuccessCode.OK, paymentFacade.makeDepositTransfer()));
    }
}
