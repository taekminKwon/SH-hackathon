package com.example.hackathon.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum SuccessCode {
    /*
        200 OK
     */
    OK(HttpStatus.OK, "요청 성공"),
    UPDATED(HttpStatus.OK, "수정 완료"),
    DELETED(HttpStatus.OK, "삭제 완료"),

    /*
       201 Created
     */
    CREATED(HttpStatus.CREATED, "생성 완료"),

    /*
        203 Multi-Status
     */
    MULTISTATUS(HttpStatus.MULTI_STATUS, "일부만 처리에 성공했습니다."),

    /*
       204 No Content
     */
    NO_CONTENT(HttpStatus.NO_CONTENT, "요청 성공(반환 데이터 없음)");

    private final HttpStatus status;
    private final String message;

    public int getStatusCode() {
        return status.value();
    }
}
