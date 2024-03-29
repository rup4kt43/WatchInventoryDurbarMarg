package com.example.watchinventorydurbarmarg.UserSettings.POJO.ChangePasswordPOJO;

import com.google.gson.annotations.SerializedName;

public class ChangePasswordResponse {

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private String status;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return
                "ChangePasswordResponse{" +
                        "message = '" + message + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }
}