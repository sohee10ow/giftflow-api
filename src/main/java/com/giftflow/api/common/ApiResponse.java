package com.giftflow.api.common;

public class ApiResponse<T> {
    private boolean success;
    private T data;
    private ApiError error;
    private String traceId;

    public boolean isSuccess() {
        return success;
    }

    public T getData() {
        return data;
    }

    public ApiError getError() {
        return error;
    }

    public String getTraceId() {
        return traceId;
    }

    public static <T> ApiResponse<T> success(T data, String traceId) {
        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.success = true;
        apiResponse.data = data;
        apiResponse.error = null;
        apiResponse.traceId = traceId;

        return apiResponse;
    }


    public static <T> ApiResponse<T> fail(T data, ApiError error, String traceId) {
        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.success = false;
        apiResponse.data = null;
        apiResponse.error = error;
        apiResponse.traceId = traceId;

        return apiResponse;
    }



}
