package com.example.hackathon.common.shDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class SHApiRECSingleResponse<T> {
    @JsonProperty("Header")
    private SHHeader.Response header;
    @JsonProperty("REC")
    private T responseBody;

    public SHApiRECSingleResponse(SHHeader.Response header, T responseBody) {
        this.header = header;
        this.responseBody = responseBody;
    }

    public static <T> SHApiRECSingleResponse<T> of(SHHeader.Response header, T responseBody) {
        SHApiRECSingleResponse<T> response = new SHApiRECSingleResponse<>();
        response.header = header;
        response.responseBody = responseBody;
        return response;
    }
}
