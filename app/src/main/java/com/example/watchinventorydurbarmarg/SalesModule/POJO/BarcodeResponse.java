package com.example.watchinventorydurbarmarg.SalesModule.POJO;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BarcodeResponse {

    @SerializedName("formatters")
    private List<Object> formatters;

    @SerializedName("declaredType")
    private Object declaredType;

    @SerializedName("contentTypes")
    private List<Object> contentTypes;

    @SerializedName("value")
    private List<ValueItem> value;

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

    public void setValue(List<ValueItem> value) {
        this.value = value;
    }

    public List<ValueItem> getValue() {
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
                "BarcodeResponse{" +
                        "formatters = '" + formatters + '\'' +
                        ",declaredType = '" + declaredType + '\'' +
                        ",contentTypes = '" + contentTypes + '\'' +
                        ",value = '" + value + '\'' +
                        ",statusCode = '" + statusCode + '\'' +
                        "}";
    }
}