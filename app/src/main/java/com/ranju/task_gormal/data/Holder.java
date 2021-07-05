package com.ranju.task_gormal.data;

import com.ranju.task_gormal.model.AddBookRes;
import com.ranju.task_gormal.model.AllBookRes;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Holder {
    @GET(Constants.GET_BOOK)
    Call<AllBookRes> getAllBooks();

    @FormUrlEncoded
    @POST(Constants.ADD_BOOK)
    Call<AddBookRes> addBooks(@Field(Constants.NAME_KEY) String bookName,
                              @Field(Constants.DESC_KEY) String book_desc,
                              @Field(Constants.QNT_KEY) String book_quantity,
                              @Field(Constants.PRICE_KEY) String book_price,
                              @Field(Constants.PHONE_KEY) String mobile
                              );

}
