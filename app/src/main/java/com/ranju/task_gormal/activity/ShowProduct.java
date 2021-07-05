package com.ranju.task_gormal.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ranju.task_gormal.R;
import com.ranju.task_gormal.adapter.BookListAdapter;
import com.ranju.task_gormal.model.AllViewModel;
import com.ranju.task_gormal.model.BookModel;

import java.util.ArrayList;
import java.util.List;

public class ShowProduct extends AppCompatActivity {

    private RecyclerView allBookRec;

    private AllViewModel allViewModel;

    private List<BookModel> bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_product);
        allBookRec = findViewById(R.id.bookRec);
        allBookRec.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        allViewModel = new ViewModelProvider(this).get(AllViewModel.class);
        allViewModel.getAllBookData().observe(this, allBookResults -> {
            if (allBookResults!=null){
                bookList = new ArrayList<>();
                bookList = allBookResults;
                System.out.println("ALL_BOOK: "+bookList.size());
                allBookRec.setAdapter(new BookListAdapter(bookList,ShowProduct.this));
                allBookRec.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
            }
        });
    }
}