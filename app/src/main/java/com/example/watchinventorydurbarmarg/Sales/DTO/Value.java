package com.example.watchinventorydurbarmarg.Sales.DTO;

import com.google.gson.annotations.SerializedName;


public class Value {

    @SerializedName("PRATE_A")
    private int pRATEA;

    @SerializedName("RATE_A")
    private int rATEA;

    @SerializedName("MODEL")
    private String mODEL;

    @SerializedName("PURCHASE_DATE")
    private String pURCHASEDATE;

    public void setPRATEA(int pRATEA) {
        this.pRATEA = pRATEA;
    }

    public int getPRATEA() {
        return pRATEA;
    }

    public void setRATEA(int rATEA) {
        this.rATEA = rATEA;
    }

    public int getRATEA() {
        return rATEA;
    }

    public void setMODEL(String mODEL) {
        this.mODEL = mODEL;
    }

    public String getMODEL() {
        return mODEL;
    }

    public void setPURCHASEDATE(String pURCHASEDATE) {
        this.pURCHASEDATE = pURCHASEDATE;
    }

    public String getPURCHASEDATE() {
        return pURCHASEDATE;
    }

    @Override
    public String toString() {
        return
                "Value{" +
                        "pRATE_A = '" + pRATEA + '\'' +
                        ",rATE_A = '" + rATEA + '\'' +
                        ",mODEL = '" + mODEL + '\'' +
                        ",pURCHASE_DATE = '" + pURCHASEDATE + '\'' +
                        "}";
    }
}