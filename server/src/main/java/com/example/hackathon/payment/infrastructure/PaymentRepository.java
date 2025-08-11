package com.example.hackathon.payment.infrastructure;

import com.example.hackathon.account.domain.Account;
import com.example.hackathon.payment.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Account> {
}
