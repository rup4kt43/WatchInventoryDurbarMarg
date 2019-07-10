package com.example.watchinventorydurbarmarg.UserLogin.POJO;

import com.google.gson.annotations.SerializedName;


public class Value {

    @SerializedName("role")
    private String role;

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return
                "Value{" +
                        "role = '" + role + '\'' +
                        "}";
    }
}