package com.example.watchinventorydurbarmarg.UserLogin.POJO;

import com.google.gson.annotations.SerializedName;

public class ValueItem {

    @SerializedName("ROLE")
    private String rOLE;

    public void setROLE(String rOLE) {
        this.rOLE = rOLE;
    }

    public String getROLE() {
        return rOLE;
    }

    @Override
    public String toString() {
        return
                "ValueItem{" +
                        "rOLE = '" + rOLE + '\'' +
                        "}";
    }
}