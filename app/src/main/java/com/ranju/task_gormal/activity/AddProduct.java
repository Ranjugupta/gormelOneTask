package com.ranju.task_gormal.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.ranju.task_gormal.R;
import com.ranju.task_gormal.data.ConnectData;
import com.ranju.task_gormal.data.Holder;
import com.ranju.task_gormal.room.ProductRoomDatabase;
import com.ranju.task_gormal.model.ProductViewModel;
import com.ranju.task_gormal.model.AddBookRes;
import com.ranju.task_gormal.model.BookModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddProduct extends AppCompatActivity implements View.OnClickListener {


    private static final String TAG = "ADD_LOG";

    private Button addOption, syncOption;

    private List<BookModel> bookList;

    private ProductViewModel productViewModel;

    private ProductRoomDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        //initializing database
        database = ProductRoomDatabase.getDatabase(AddProduct.this);
        productViewModel = new ViewModelProvider.AndroidViewModelFactory(AddProduct.this
                .getApplication())
                .create(ProductViewModel.class);

        productViewModel.getAllBookData().observe(AddProduct.this,bookModels -> {
            bookList = new ArrayList<>();
            bookList = bookModels;
        });

        //initialize controls
        addOption = findViewById(R.id.add_product_btn);
        syncOption = findViewById(R.id.sync_btn);

        //click events
        addOption.setOnClickListener(this);
        syncOption.setOnClickListener(this);

    }

    private void reset(List<BookModel> bookModels) {
        this.bookList = bookModels;
        database.productDao().deleteAll(bookList);
        Log.d("ALL_DELETED", "onResponse: "+ bookList.size());
    }


    private void SyncOnline(BookModel model) {
        //TODO :here to sync all the data from local
        Holder holder = ConnectData.getConnect().holder();
        Call<AddBookRes> addBookResCall = holder.addBooks(model.bookName,model.bookDesc,String.valueOf(model.bookQuantity),
                model.bookPrice,model.userPhone);
        addBookResCall.enqueue(new Callback<AddBookRes>() {
            @Override
            public void onResponse(Call<AddBookRes> call, Response<AddBookRes> response) {
                if (response.isSuccessful()){
                    if (response.body().results.success==1)
                        Toast.makeText(AddProduct.this,response.body().results.message,Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "onResponse: "+model.getBookName());
                }
            }
            @Override
            public void onFailure(Call<AddBookRes> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());
            }
        });
    }

    @Override
    public void onBackPressed() {
            super.onBackPressed();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_product_btn:
                Intent formIntent = new Intent(AddProduct.this,ProductForm.class);
                startActivity(formIntent);
                break;
            case R.id.sync_btn:
                if (bookList.size()!=0){
                    for (BookModel model:bookList){
                        SyncOnline(model);
                    }
                    reset(bookList);
                }

                else Snackbar.make(v,"No data to sync", BaseTransientBottomBar.LENGTH_SHORT).show();
                break;
        }
    }

}