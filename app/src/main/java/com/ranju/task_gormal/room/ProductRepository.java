package com.ranju.task_gormal.room;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.ranju.task_gormal.model.BookModel;
import com.ranju.task_gormal.room.ProductDao;
import com.ranju.task_gormal.room.ProductRoomDatabase;

import java.util.List;

public class ProductRepository {

    private ProductDao productDao;

    private LiveData<List<BookModel>> bookModelLiveData;

    public ProductRepository(Application application) {
        ProductRoomDatabase db  = ProductRoomDatabase.getDatabase(application);
        productDao = db.productDao();

        bookModelLiveData = productDao.getAllBooks();
    }

    public LiveData<List<BookModel>> getBookModelLiveData() {
        return bookModelLiveData;
    }

    public void insert(BookModel bookModel){
        ProductRoomDatabase.databaseWriteExecutor.execute(()->{
            productDao.insert(bookModel);
        });

    }

    public void deleteAll(List<BookModel> models){
        productDao.deleteAll(models);
    }

}
