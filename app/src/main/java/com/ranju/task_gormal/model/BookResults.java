package com.ranju.task_gormal.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookResults {
    @SerializedName("success")
    @Expose
    public Integer success;
    @SerializedName("message")
    @Expose
    public String message;
}
