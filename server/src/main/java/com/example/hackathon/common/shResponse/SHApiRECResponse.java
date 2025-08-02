package com.example.hackathon.common.shResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class SHApiRECResponse<T> {
    @JsonProperty("Header")
    private SHHeader.Response header;
    @JsonProperty("REC")
    private List<T> responseBody;

    @Builder
    public SHApiRECResponse(SHHeader.Response header, List<T> responseBody) {
        this.header = header;
        this.responseBody = responseBody;
    }
}
