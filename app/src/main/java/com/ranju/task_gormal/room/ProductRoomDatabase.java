package com.ranju.task_gormal.room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.ranju.task_gormal.data.Constants;
import com.ranju.task_gormal.model.BookModel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {BookModel.class},version = 1,exportSchema = false)
public abstract class ProductRoomDatabase extends RoomDatabase {
    public abstract ProductDao productDao();

    private static final int NUMBER_OF_THREAD = 4;

    private static volatile ProductRoomDatabase INSTANCE;

    public static final ExecutorService databaseWriteExecutor
            = Executors.newFixedThreadPool(NUMBER_OF_THREAD);

    public synchronized static ProductRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ProductRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ProductRoomDatabase.class, Constants.DN_NAME)
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
//                            .addCallback(sRoomDatabaseCallback) // I have to delete it
                            .build();
                }
            }
        }

        return INSTANCE;
    }

//    public abstract ProductDao productDao();

    private static final RoomDatabase.Callback sRoomDatabaseCallback =
            new Callback() {
                @Override
                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                    super.onCreate(db);
                    databaseWriteExecutor.execute(() -> {
                        ProductDao productDao = INSTANCE.productDao();
//                        productDao.deleteAll();
                        productDao.getAllBooks();

                    });
                }
            };



}
