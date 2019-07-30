package com.example.watchinventorydurbarmarg.SalesModule.POJO;


import com.google.gson.annotations.SerializedName;


public class SalesResponse {

    @SerializedName("result")
    private Result result;

    @SerializedName("exception")
    private Object exception;

    @SerializedName("asyncState")
    private Object asyncState;

    @SerializedName("isFaulted")
    private boolean isFaulted;

    @SerializedName("isCanceled")
    private boolean isCanceled;

    @SerializedName("creationOptions")
    private int creationOptions;

    @SerializedName("isCompletedSuccessfully")
    private boolean isCompletedSuccessfully;

    @SerializedName("id")
    private int id;

    @SerializedName("status")
    private int status;

    @SerializedName("isCompleted")
    private boolean isCompleted;

    public void setResult(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

    public void setException(Object exception) {
        this.exception = exception;
    }

    public Object getException() {
        return exception;
    }

    public void setAsyncState(Object asyncState) {
        this.asyncState = asyncState;
    }

    public Object getAsyncState() {
        return asyncState;
    }

    public void setIsFaulted(boolean isFaulted) {
        this.isFaulted = isFaulted;
    }

    public boolean isIsFaulted() {
        return isFaulted;
    }

    public void setIsCanceled(boolean isCanceled) {
        this.isCanceled = isCanceled;
    }

    public boolean isIsCanceled() {
        return isCanceled;
    }

    public void setCreationOptions(int creationOptions) {
        this.creationOptions = creationOptions;
    }

    public int getCreationOptions() {
        return creationOptions;
    }

    public void setIsCompletedSuccessfully(boolean isCompletedSuccessfully) {
        this.isCompletedSuccessfully = isCompletedSuccessfully;
    }

    public boolean isIsCompletedSuccessfully() {
        return isCompletedSuccessfully;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public boolean isIsCompleted() {
        return isCompleted;
    }

    @Override
    public String toString() {
        return
                "SalesResponse{" +
                        "result = '" + result + '\'' +
                        ",exception = '" + exception + '\'' +
                        ",asyncState = '" + asyncState + '\'' +
                        ",isFaulted = '" + isFaulted + '\'' +
                        ",isCanceled = '" + isCanceled + '\'' +
                        ",creationOptions = '" + creationOptions + '\'' +
                        ",isCompletedSuccessfully = '" + isCompletedSuccessfully + '\'' +
                        ",id = '" + id + '\'' +
                        ",status = '" + status + '\'' +
                        ",isCompleted = '" + isCompleted + '\'' +
                        "}";
    }
}