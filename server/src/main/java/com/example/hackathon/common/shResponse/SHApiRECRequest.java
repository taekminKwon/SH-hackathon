package com.example.hackathon.common.shResponse;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SHApiRECRequest<T> {
    private SHHeader.Request header;
    private T REC;

    private SHApiRECRequest<T> makeRequest(T REC) {
        SHApiRECRequest<T> shApiRECRequest = new SHApiRECRequest<>();
        shApiRECRequest.header = SHHeader.Request.makeHeader(
                "apiName", "12341234"
        );
        shApiRECRequest.REC = REC;
        return shApiRECRequest;
    }
}
