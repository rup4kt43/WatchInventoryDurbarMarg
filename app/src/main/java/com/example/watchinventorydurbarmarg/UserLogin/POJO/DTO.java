package com.example.watchinventorydurbarmarg.UserLogin.POJO;

import com.google.gson.annotations.SerializedName;

public class DTO {

    @SerializedName("uname")
    private String username;

    @SerializedName("password")
    private String password;

    @SerializedName("division")
    private String division;

    @SerializedName("role")
    private String role;


    public DTO(String username, String password, String division, String role) {
        this.username = username;
        this.password = password;
        this.division = division;
        this.role = role;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
