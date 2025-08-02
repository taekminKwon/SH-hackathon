package com.example.hackathon.common.shResponse;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SHHeader {
    private static final String API_KEY = "12345678";
    @Getter
    @Slf4j
    @ToString
    public static class Request {
        private String apiName;
        private String transmissionDate;
        private String transmissionTime;
        private String institutionCode;
        private String fintechAppNo;
        private String apiServiceCode;
        private String institutionTransactionUniqueNo;
        private String apiKey;
        private String userKey;

        @Builder
        public Request(
                String apiName,
                String transmissionDate,
                String transmissionTime,
                String institutionCode,
                String fintechAppNo,
                String apiServiceCode,
                String institutionTransactionUniqueNo,
                String apiKey,
                String userKey
        ) {
            this.apiName = apiName;
            this.transmissionDate = transmissionDate;
            this.transmissionTime = transmissionTime;
            this.institutionCode = institutionCode;
            this.fintechAppNo = fintechAppNo;
            this.apiServiceCode = apiServiceCode;
            this.institutionTransactionUniqueNo = institutionTransactionUniqueNo;
            this.apiKey = apiKey;
            this.userKey = userKey;
        }

        public Request makeRequest(
                String apiName,
                String institutionTransactionUniqueNo,
                String userKey
        ) {
            Request request = Request.builder()
                    .apiName(apiName)
                    .transmissionDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")))
                    .transmissionTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("hhmmdd")))
                    .institutionCode("00100")
                    .fintechAppNo("001")
                    .apiServiceCode(apiName)
                    .institutionTransactionUniqueNo(institutionTransactionUniqueNo)
                    .apiKey(API_KEY)
                    .userKey(userKey)
                    .build();

            log.info(request.toString());
            return request;
        }
    }

    @Getter
    public static class Response {
        private String responseCode;
        private String responseMessage;
        private String apiName;
        private String transmissionDate;
        private String transmissionTime;
        private String institutionCode;
        private String fintechAppNo;
        private String apiServiceCode;
        private String institutionTransactionUniqueNo;

        @Builder
        public Response(
                String responseCode,
                String responseMessage,
                String apiName,
                String transmissionDate,
                String transmissionTime,
                String institutionCode,
                String fintechAppNo,
                String apiServiceCode,
                String institutionTransactionUniqueNo
        ) {
            this.responseCode = responseCode;
            this.responseMessage = responseMessage;
            this.apiName = apiName;
            this.transmissionDate = transmissionDate;
            this.transmissionTime = transmissionTime;
            this.institutionCode = institutionCode;
            this.fintechAppNo = fintechAppNo;
            this.apiServiceCode = apiServiceCode;
            this.institutionTransactionUniqueNo = institutionTransactionUniqueNo;
        }
    }
}
