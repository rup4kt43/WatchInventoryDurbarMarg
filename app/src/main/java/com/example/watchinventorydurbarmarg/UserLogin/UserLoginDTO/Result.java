package com.example.watchinventorydurbarmarg.UserLogin.UserLoginDTO;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Result {

    @SerializedName("formatters")
    private List<Object> formatters;

    @SerializedName("declaredType")
    private Object declaredType;

    @SerializedName("contentTypes")
    private List<Object> contentTypes;

    @SerializedName("value")
    private Value value;

    @SerializedName("statusCode")
    private int statusCode;

    public void setFormatters(List<Object> formatters) {
        this.formatters = formatters;
    }

    public List<Object> getFormatters() {
        return formatters;
    }

    public void setDeclaredType(Object declaredType) {
        this.declaredType = declaredType;
    }

    public Object getDeclaredType() {
        return declaredType;
    }

    public void setContentTypes(List<Object> contentTypes) {
        this.contentTypes = contentTypes;
    }

    public List<Object> getContentTypes() {
        return contentTypes;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Value getValue() {
        return value;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public String toString() {
        return
                "Result{" +
                        "formatters = '" + formatters + '\'' +
                        ",declaredType = '" + declaredType + '\'' +
                        ",contentTypes = '" + contentTypes + '\'' +
                        ",value = '" + value + '\'' +
                        ",statusCode = '" + statusCode + '\'' +
                        "}";
    }
}