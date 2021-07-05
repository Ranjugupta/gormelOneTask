package com.ranju.task_gormal.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.ranju.task_gormal.model.BookModel;

import java.util.List;

import retrofit2.http.DELETE;

@Dao
public interface ProductDao {
    //Inters query
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(BookModel book);

    //delete query
    @Delete
    void deleteAll(List<BookModel> bookModel);

    //delete all query
//    @Query("DELETE FROM productlist")
//    void deleteAll();

    @Query("SELECT * FROM productlist ORDER BY product_price ASC")
    LiveData<List<BookModel>> getAllBooks ();

}
