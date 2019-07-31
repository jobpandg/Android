package com.lifi.jobhelper.response;

public class BaseResponse {
    private boolean status;
    private String message;

    public boolean isStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
