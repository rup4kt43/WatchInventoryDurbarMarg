package com.example.watchinventorydurbarmarg.UserSettings.POJO.UserListPOJO;

import com.google.gson.annotations.SerializedName;


public class ValueItem {

    @SerializedName("UNAME")
    private String uNAME;

    public void setUNAME(String uNAME) {
        this.uNAME = uNAME;
    }

    public String getUNAME() {
        return uNAME;
    }

    @Override
    public String toString() {
        return
                "ValueItem{" +
                        "uNAME = '" + uNAME + '\'' +
                        "}";
    }
}