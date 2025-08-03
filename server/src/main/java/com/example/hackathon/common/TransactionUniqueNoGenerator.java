package com.example.hackathon.common;
import java.security.SecureRandom;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionUniqueNoGenerator {
    private static final int TOTAL_LENGTH = 20;
    private static final SecureRandom random = new SecureRandom();

    public static String generateDigits(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    public static String generateUniqueNo() {
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        return now + generateDigits(TOTAL_LENGTH - now.length());
    }
}
