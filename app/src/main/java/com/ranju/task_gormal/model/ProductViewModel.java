package com.ranju.task_gormal.model;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ranju.task_gormal.model.BookModel;
import com.ranju.task_gormal.room.ProductRepository;

import java.util.List;

public class ProductViewModel extends AndroidViewModel {

    public static ProductRepository repository;

    public final LiveData<List<BookModel>> listLiveData;

    public ProductViewModel(Application application) {
        super(application);
        repository = new ProductRepository(application);
        listLiveData = repository.getBookModelLiveData();
    }

    public LiveData<List<BookModel>> getAllBookData() { return listLiveData; }

    public static void inset(BookModel bookModel) { repository.insert(bookModel); }

    public static void deleteAll(List<BookModel> models){ repository.deleteAll(models);}


}
