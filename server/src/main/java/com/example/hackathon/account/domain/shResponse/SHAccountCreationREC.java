package com.example.hackathon.account.domain.shResponse;

import lombok.Getter;

import java.util.List;

@Getter
public class SHAccountCreationREC {
    private String bankCode;
    private String accountNo;
    private List<Currency> currency;

    private static class Currency {
        private String currency;
        private String currencyName;
    }
}
