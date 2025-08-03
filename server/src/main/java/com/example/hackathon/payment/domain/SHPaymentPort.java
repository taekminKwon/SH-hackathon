package com.example.hackathon.payment.domain;

import com.example.hackathon.common.shDto.SHApiRECResponse;
import com.example.hackathon.payment.domain.shDto.SHPaymentCommand;
import com.example.hackathon.payment.domain.shDto.SHPaymentInfo;

public interface SHPaymentPort {
    SHApiRECResponse<SHPaymentInfo> storePayment(SHPaymentCommand command);
}
