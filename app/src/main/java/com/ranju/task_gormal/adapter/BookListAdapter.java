package com.ranju.task_gormal.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ranju.task_gormal.R;
import com.ranju.task_gormal.model.BookModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.BookHolder> {

    private List<BookModel> bookResults;

    private Context Ctx;

    public BookListAdapter(List<BookModel> bookResults, Context ctx) {
        this.bookResults = bookResults;
        Ctx = ctx;
    }

    @NonNull
    @Override
    public BookHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BookHolder(LayoutInflater.from(Ctx).inflate(R.layout.book_list_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull BookHolder holder, int position) {
        holder.bookBind();
    }

    @Override
    public int getItemCount() {
        return bookResults.size();
    }

    public class BookHolder extends RecyclerView.ViewHolder {
        ImageView coverImg;
        TextView showName,showDesc,authorName,bookPrice;
        public BookHolder(@NonNull View itemView) {
            super(itemView);
            coverImg = itemView.findViewById(R.id.coverImg);
            showName = itemView.findViewById(R.id.showName);
            showDesc = itemView.findViewById(R.id.showDesc);
            authorName = itemView.findViewById(R.id.authorName);
            bookPrice = itemView.findViewById(R.id.bookPrice);
        }

        public void bookBind(){
            int position = getAdapterPosition();
            BookModel book = bookResults.get(position);
            setCoverImg(book.bookImgUrl);
            setShowName(book.bookName);
            setShowDesc(book.bookDesc);
            setAuthorName(book.bookAuthor);
            setBookPrice(book.bookPrice);
        }

        public void setCoverImg(String  cover_Img) {
            Picasso.with(Ctx)
                    .load(cover_Img)
                    .fit()
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(coverImg);
        }

        public void setShowName(String show_Name) {
            showName.setText(show_Name);
        }

        public void setShowDesc(String show_Desc) {
            showDesc.setText(show_Desc);
        }

        public void setAuthorName(String author_Name) {
            authorName.setText("Author :"+author_Name);
        }

        public void setBookPrice(String book_Price) {
//            bookPrice.setText("Price : "+"\u20B9"+book_Price);
            bookPrice.setText("Price :"+"\u20A8"+book_Price);
        }
    }
}
