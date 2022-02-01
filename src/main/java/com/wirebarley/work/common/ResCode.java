package com.wirebarley.work.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum ResCode {
    REQUEST_API_SUCCESS (0,"API 응답 성공"),
    REQUEST_API_FALL (9999,"API 응답 실패"),

    VALIDATION_ERROR(9000,"유효성검사 실패");

    private int code;
    private String value;
}
