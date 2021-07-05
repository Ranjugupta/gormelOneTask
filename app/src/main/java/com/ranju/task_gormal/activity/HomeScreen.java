package com.ranju.task_gormal.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ranju.task_gormal.R;

public class HomeScreen extends AppCompatActivity {

    private TextView addBtn,bookBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        addBtn = findViewById(R.id.add_btn);
        bookBtn = findViewById(R.id.book_btn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, AddProduct.class);
                startActivity(intent);
            }
        });
        bookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, ShowProduct.class);
                startActivity(intent);
            }
        });

    }
}