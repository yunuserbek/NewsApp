package com.example.newsapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsapp.R;
import com.example.newsapp.model.ModelClass;
import com.example.newsapp.ui.WebActivity;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    Context context;

    public NewsAdapter(Context context, ArrayList<ModelClass> modelClassArrayList) {
        this.context = context;
        this.modelClassArrayList = modelClassArrayList;
    }

    ArrayList<ModelClass> modelClassArrayList;


    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {
   holder.cardView.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {

           Intent intent =new Intent(context,WebActivity.class);
           intent.putExtra("url",modelClassArrayList.get(position).getUrl());
           context.startActivity(intent);
       }
   });
        holder.mtime.setText("pubished At: -"+ modelClassArrayList.get(position).getPublishedAt());
        holder.mauthor.setText(modelClassArrayList.get(position).getAuthor());
        holder.mheading.setText( modelClassArrayList.get(position).getTitle());
        holder.mcontent.setText( modelClassArrayList.get(position).getDescription());
        holder.mtime.setText(modelClassArrayList.get(position).getPublishedAt());
        Glide.with(context).load(modelClassArrayList.get(position).getUrlToImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return modelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mheading,mcontent,mauthor,mcategory,mtime;
        ImageView imageView;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mheading = itemView.findViewById(R.id.mainheading);
            mcontent = itemView.findViewById(R.id.content);
            mauthor = itemView.findViewById(R.id.author);
            mtime = itemView.findViewById(R.id.time);
            imageView = itemView.findViewById(R.id.imageview);
            cardView = itemView.findViewById(R.id.cardview);


        }
    }
}
