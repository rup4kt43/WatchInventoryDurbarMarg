package com.example.watchinventorydurbarmarg.Commission.POJO;

import com.google.gson.annotations.SerializedName;

public class ValueItem {

    @SerializedName("MCODE")
    private String mCODE;

    @SerializedName("PRATE_A")
    private double pRATEA;

    @SerializedName("RATE_A")
    private double rATEA;

    @SerializedName("MODEL")
    private Object mODEL;

    @SerializedName("PURCHASE_DATE")
    private String pURCHASEDATE;

    @SerializedName("DESCA")
    private String dESCA;

    public void setMCODE(String mCODE) {
        this.mCODE = mCODE;
    }

    public String getMCODE() {
        return mCODE;
    }

    public void setPRATEA(double pRATEA) {
        this.pRATEA = pRATEA;
    }

    public double getPRATEA() {
        return pRATEA;
    }

    public void setRATEA(double rATEA) {
        this.rATEA = rATEA;
    }

    public double getRATEA() {
        return rATEA;
    }

    public void setMODEL(Object mODEL) {
        this.mODEL = mODEL;
    }

    public Object getMODEL() {
        return mODEL;
    }

    public void setPURCHASEDATE(String pURCHASEDATE) {
        this.pURCHASEDATE = pURCHASEDATE;
    }

    public String getPURCHASEDATE() {
        return pURCHASEDATE;
    }

    public void setDESCA(String dESCA) {
        this.dESCA = dESCA;
    }

    public String getDESCA() {
        return dESCA;
    }

    @Override
    public String toString() {
        return
                "ValueItem{" +
                        "mCODE = '" + mCODE + '\'' +
                        ",pRATE_A = '" + pRATEA + '\'' +
                        ",rATE_A = '" + rATEA + '\'' +
                        ",mODEL = '" + mODEL + '\'' +
                        ",pURCHASE_DATE = '" + pURCHASEDATE + '\'' +
                        ",dESCA = '" + dESCA + '\'' +
                        "}";
    }
}