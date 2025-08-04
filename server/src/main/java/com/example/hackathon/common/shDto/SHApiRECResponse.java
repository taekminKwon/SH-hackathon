package com.example.hackathon.common.shDto;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    public SHApiRECResponse(SHHeader.Response header, List<T> responseBody) {
        this.header = header;
        this.responseBody = responseBody;
    }

    public static <T> SHApiRECResponse<T> of(SHHeader.Response header, List<T> responseBody) {
        SHApiRECResponse<T> response = new SHApiRECResponse<>();
        response.header = header;
        response.responseBody = responseBody;
        return response;
    }
}
