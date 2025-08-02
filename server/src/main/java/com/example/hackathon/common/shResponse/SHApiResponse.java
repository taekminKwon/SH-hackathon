package com.example.hackathon.common.shResponse;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SHApiResponse<T> {
    private SHHeader.Response header;
    private T responseBody;

    @Builder
    public SHApiResponse (SHHeader.Response header, T responseBody) {
        this.header = header;
        this.responseBody = responseBody;
    }
}
