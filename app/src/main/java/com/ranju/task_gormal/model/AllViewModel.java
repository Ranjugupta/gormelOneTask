package com.ranju.task_gormal.model;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ranju.task_gormal.data.ConnectData;
import com.ranju.task_gormal.data.Holder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllViewModel extends ViewModel {

    private static final String TAG = "AllBookModel";
    private MutableLiveData<List<BookModel>> AllBookData;

    public AllViewModel() {
        if (AllBookData==null)
            AllBookData = new MutableLiveData<List<BookModel>>();
    }

    public MutableLiveData<List<BookModel>> getAllBookData() {
        getAllBokks();
        return AllBookData;
    }

    private void getAllBokks() {
        Holder holder = ConnectData.getConnect().holder();
        Call<AllBookRes> allBookResCall = holder.getAllBooks();
        allBookResCall.enqueue(new Callback<AllBookRes>() {
            @Override
            public void onResponse(Call<AllBookRes> call, Response<AllBookRes> response) {
                if (response.isSuccessful()){
                    Log.d(TAG, "onResponse: "+ response.body().bookModels.size());
                    if (response.body().bookModels.size()>0){
                        AllBookData.setValue(response.body().bookModels);
                    }
                }
            }

            @Override
            public void onFailure(Call<AllBookRes> call, Throwable t) {
                Log.d(TAG, "onResponse: "+ t.getMessage());
            }
        });
    }
}
