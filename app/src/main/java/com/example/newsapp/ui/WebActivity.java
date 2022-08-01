package com.example.newsapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newsapp.R;
import com.example.newsapp.databinding.ActivityWebBinding;


public class WebActivity extends AppCompatActivity {


    private ActivityWebBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        binding = ActivityWebBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        binding.webView.setWebViewClient(new WebViewClient());
        binding.webView.loadUrl(url);
    }
}