package com.example.hackathon.payment.infrastructure;

import com.example.hackathon.common.shDto.SHApiRECResponse;
import com.example.hackathon.common.shDto.SHHeader;
import com.example.hackathon.payment.domain.SHPaymentPort;
import com.example.hackathon.payment.domain.shDto.SHPaymentCommand;
import com.example.hackathon.payment.domain.shDto.SHPaymentInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@RequiredArgsConstructor
public class SHMockPaymentAdapter implements SHPaymentPort {
    private static final Map<Long, SHPaymentInfo> db = new ConcurrentHashMap<>();
    private static long id = 0;
    @Override
    public SHApiRECResponse<SHPaymentInfo> storePayment(SHPaymentCommand command) {
        List<SHPaymentInfo> list = new ArrayList<>();
        ++id;
        SHPaymentInfo withdrawal = createWithdrawal(command);
        db.put(id, withdrawal);
        ++id;
        SHPaymentInfo deposit = createDeposit(command);
        list.add(withdrawal);
        list.add(deposit);
        db.put(++id, deposit);
        return SHApiRECResponse.of(SHHeader.Response
                .builder()
                .responseCode("H0000")
                .responseMessage("정상처리 되었습니다")
                .apiName("updateDemandDepositAccountTransfer")
                .transmissionDate("20240401")
                .transmissionTime("103500")
                .institutionCode("00100")
                .fintechAppNo("12341")
                .apiServiceCode("12341234")
                .institutionTransactionUniqueNo("123123123123")
                .build(), list);
    }


    public SHPaymentInfo createWithdrawal(SHPaymentCommand command) {
        return SHPaymentInfo.builder()
                .transactionUniqueNo(id)
                .accountNo(command.getWithdrawalAccountNo())
                .transactionDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMdd")))
                .transactionType("2")
                .transactionTypeName("출금")
                .transactionAccountNo(command.getDepositAccountNo())
                .build();
    }

    public SHPaymentInfo createDeposit(SHPaymentCommand command) {
        return SHPaymentInfo.builder()
                .transactionUniqueNo(id)
                .accountNo(command.getDepositAccountNo())
                .transactionDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMdd")))
                .transactionType("1")
                .transactionTypeName("입금")
                .transactionAccountNo(command.getWithdrawalAccountNo())
                .build();
    }
}
