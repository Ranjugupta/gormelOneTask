package com.ranju.task_gormal.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddBookRes {
    @SerializedName("results")
    @Expose
    public BookResults results;

}
