package com.example.newsapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.R;
import com.example.newsapp.adapter.NewsAdapter;
import com.example.newsapp.model.ModelClass;
import com.example.newsapp.model.mainNews;
import com.example.newsapp.network.ApiUtilities;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SportsFragment extends Fragment {
    String api ="38c069aa8d8e45fcba179819d8fc0407";
    ArrayList<ModelClass> modelClassArrayList;
    NewsAdapter newsAdapter;
    String country ="tr";
    private RecyclerView recyclerViewofsports;
    private String category ="sports";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.sportsfragment,null);
        recyclerViewofsports =  v.findViewById(R.id.recyclerviewofsports);
        modelClassArrayList = new ArrayList<>();
        recyclerViewofsports.setLayoutManager(new LinearLayoutManager(getContext()));
        newsAdapter =new NewsAdapter(getContext(),modelClassArrayList);
        recyclerViewofsports.setAdapter(newsAdapter);

        findNews();
        return v;
    }

    private void findNews() {
        ApiUtilities. getApiInterFace().getCategoryNews(country,category,100,api).enqueue(new Callback<mainNews>() {
            @Override
            public void onResponse(Call<mainNews> call, Response<mainNews> response) {
                if (response.isSuccessful()){
                    modelClassArrayList.addAll(response.body().getArticles());
                    newsAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<mainNews> call, Throwable t) {

            }
        });
    }
}