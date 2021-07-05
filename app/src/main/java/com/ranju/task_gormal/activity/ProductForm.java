package com.ranju.task_gormal.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.snackbar.Snackbar;
import com.ranju.task_gormal.R;
import com.ranju.task_gormal.data.Constants;
import com.ranju.task_gormal.model.ProductViewModel;
import com.ranju.task_gormal.model.BookModel;

public class ProductForm extends AppCompatActivity {

    private static final String TAG = "PRODUCT_FORM";

    private EditText et_pd_name, et_pd_description, et_pd_quantity, et_pd_price;

    private Button saveBtn;

    private String pdName, pdDescription, pdQuantity, pdPrice;

    private ProductViewModel productModel;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_form_activity);

        productModel = new ViewModelProvider.AndroidViewModelFactory(ProductForm.this
                .getApplication())
                .create(ProductViewModel.class);
        et_pd_name = findViewById(R.id.et_pd_name);
        et_pd_description = findViewById(R.id.et_pd_description);
        et_pd_quantity = findViewById(R.id.et_pd_quantity);
        et_pd_price = findViewById(R.id.et_pd_price);
        saveBtn = findViewById(R.id.save_product);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!et_pd_name.getText().toString().isEmpty()
                        && !et_pd_description.getText().toString().isEmpty()
                        && !et_pd_quantity.getText().toString().isEmpty()
                        && !et_pd_price.getText().toString().isEmpty()) {
                    pdName = et_pd_name.getText().toString();
                    pdDescription = et_pd_description.getText().toString();
                    pdQuantity = et_pd_quantity.getText().toString();
                    pdPrice = et_pd_price.getText().toString();


                    BookModel item = new BookModel();
                    item.setBookName(pdName);
                    item.setBookDesc(pdDescription);
                    item.setBookQuantity(Integer.parseInt(pdQuantity));
                    item.setBookPrice(pdPrice);
                    item.setUserPhone(Constants.PHONE_VALE);

                    productModel.inset(item);
                    Toast.makeText(ProductForm.this,"ADDED",Toast.LENGTH_SHORT).show();

                    Snackbar.make(v, "Item saved", Snackbar.LENGTH_SHORT)
                            .show();
                    finish();
                } else {
                    Snackbar.make(v, "Empty Fields not Allowed", Snackbar.LENGTH_SHORT)
                            .show();
                }
            }
        });
    }
}
