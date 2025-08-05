package com.example.hackathon.common.shDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class SHApiRECListResponse<T> {
    @JsonProperty("Header")
    private SHHeader.Response header;
    @JsonProperty("REC")
    private List<T> responseBody;

    public SHApiRECListResponse(SHHeader.Response header, List<T> responseBody) {
        this.header = header;
        this.responseBody = responseBody;
    }

    public static <T> SHApiRECListResponse<T> of(SHHeader.Response header, List<T> responseBody) {
        SHApiRECListResponse<T> response = new SHApiRECListResponse<>();
        response.header = header;
        response.responseBody = responseBody;
        return response;
    }
}
