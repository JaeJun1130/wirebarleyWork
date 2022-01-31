package com.wirebarley.work.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum ResCode {
    REQUEST_SUCCESS (0000,"응답성공"),
    REQUEST_FALL (9999,"응답실패");

    private int code;
    private String value;
}
