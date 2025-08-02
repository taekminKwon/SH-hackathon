package com.example.hackathon.common.shResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SHApiResponse<T> {
    @JsonProperty("Header")
    private SHHeader.Response header;
    @JsonProperty("REC")
    private T responseBody;

    @Builder
    public SHApiResponse (SHHeader.Response header, T responseBody) {
        this.header = header;
        this.responseBody = responseBody;
    }
}
