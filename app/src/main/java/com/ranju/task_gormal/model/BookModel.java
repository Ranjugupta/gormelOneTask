package com.ranju.task_gormal.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ranju.task_gormal.data.Constants;

@Entity(tableName = "ProductList")
public class BookModel {

    //making private key
    @PrimaryKey(autoGenerate = true)
//    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo( name= Constants.PD_ID)
    @SerializedName("book_id")
    @Expose
    public Integer bookId;

    @ColumnInfo(name = Constants.NAME_KEY)
    @SerializedName("book_name")
    @Expose
    public String bookName;

    @ColumnInfo(name = Constants.DESC_KEY)
    @SerializedName("book_desc")
    @Expose
    public String bookDesc;

    @ColumnInfo(name = Constants.QNT_KEY)
    public Integer bookQuantity;

    @ColumnInfo(name = Constants.PHONE_KEY)
    public String userPhone;
    @SerializedName("book_author")
    @Expose
    public String bookAuthor;

    @ColumnInfo(name = Constants.PRICE_KEY)
    @SerializedName("book_price")
    @Expose
    public String bookPrice;
    @SerializedName("book_img_url")
    @Expose
    public String bookImgUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }

    public Integer getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(Integer bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(String bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookImgUrl() {
        return bookImgUrl;
    }

    public void setBookImgUrl(String bookImgUrl) {
        this.bookImgUrl = bookImgUrl;
    }
}
