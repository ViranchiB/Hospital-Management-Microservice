package com.patient_service.Payload;

public class APIResponse {
    private String error_description;
    private int error_code;
    private String path;

    public APIResponse() {
    }

    public APIResponse(String error_description, int error_code, String path) {
        this.error_description = error_description;
        this.error_code = error_code;
        this.path = path;
    }

    public String getError_description() {
        return error_description;
    }

    public void setError_description(String error_description) {
        this.error_description = error_description;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}