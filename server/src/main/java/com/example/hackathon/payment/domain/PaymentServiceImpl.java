package com.example.hackathon.payment.domain;

import com.example.hackathon.account.domain.Account;
import com.example.hackathon.account.domain.AccountReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentStore paymentStore;
    private final AccountReader accountReader;
    @Override
    public Payment createPayment(PaymentCommand command) {
        Account depositAccount = accountReader.findById(command.getDepositAccountId());
        Account withdrawalAccount = accountReader.findById(command.getWithdrawalAccountId());
        return paymentStore.store(
                Payment.createPayment(
                    command.getStudentId(),
                    command.getStoreId(),
                    command.getTransactionBalance(),
                    withdrawalAccount,
                    depositAccount
                )
        );
    }
}
