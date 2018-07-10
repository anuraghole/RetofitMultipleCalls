package com.example.aurag.slimframeworkdemo;

class ApiError {
    private int statusCode;
    private String endPoint;
    private String message="Unknown error";

    public int getStatusCode() {
        return statusCode;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public String getMessage() {
        return message;
    }
}
