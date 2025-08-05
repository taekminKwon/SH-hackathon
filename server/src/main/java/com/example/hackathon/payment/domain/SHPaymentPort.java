package com.example.hackathon.payment.domain;

import com.example.hackathon.common.shDto.SHApiRECListResponse;
import com.example.hackathon.payment.domain.shDto.SHPaymentCommand;
import com.example.hackathon.payment.domain.shDto.SHPaymentInfo;

public interface SHPaymentPort {
    SHApiRECListResponse<SHPaymentInfo> storePayment(SHPaymentCommand command);
}
