package com.groupthree.yunjianyou.utils;

import lombok.Data;

/**
 * @author He
 * @version 1.0.0
 * @title KindEditorResult
 * @create 2024/6/9 12:23
 * @description
 */
@Data
public class KindEditorResult {
    private int error;
    private String message;
    private String url;

    public KindEditorResult() {
    }

    public KindEditorResult(int error, String message, String url) {
        this.error = error;
        this.message = message;
        this.url = url;
    }

}
