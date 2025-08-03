package com.example.hackathon.payment.infrastructure;

import com.example.hackathon.common.mock.MockApiLoader;
import com.example.hackathon.common.shDto.SHApiRECResponse;
import com.example.hackathon.payment.domain.SHPaymentPort;
import com.example.hackathon.payment.domain.shDto.SHPaymentCommand;
import com.example.hackathon.payment.domain.shDto.SHPaymentInfo;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SHMockPaymentAdapter implements SHPaymentPort {
    private final MockApiLoader mockApiLoader;
    @Override
    public SHApiRECResponse<SHPaymentInfo> storePayment(SHPaymentCommand command) {
        return mockApiLoader.loadMockResponse("createTransfer", new TypeReference<SHApiRECResponse<SHPaymentInfo>>() {});
    }
}
