package com.example.hackathon.payment.interfaces;

import com.example.hackathon.common.shDto.SHApiRECListResponse;
import com.example.hackathon.payment.domain.SHPaymentPort;
import com.example.hackathon.payment.domain.shDto.SHPaymentCommand;
import com.example.hackathon.payment.domain.shDto.SHPaymentInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test/payment")
public class PaymentTestController {
    private final SHPaymentPort port;

    @PostMapping
    public ResponseEntity<SHApiRECListResponse<SHPaymentInfo>> createPayment(@RequestBody SHPaymentCommand command) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(port.storePayment(command));
    }
}
