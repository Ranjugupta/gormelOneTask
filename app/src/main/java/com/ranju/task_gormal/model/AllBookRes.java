package com.ranju.task_gormal.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AllBookRes {
    @SerializedName("results")
    @Expose
    public List<BookModel> bookModels = null;
}
