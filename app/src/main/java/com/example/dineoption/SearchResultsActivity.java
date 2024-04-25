package com.example.dineoption;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class SearchResultsActivity extends AppCompatActivity {

    TextView results;
    WebView webView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        results = findViewById(R.id.textViewResults);
        Intent intent = getIntent();
        String choices = intent.getStringExtra("Your Choices ");
        results.setText(choices);

        String url = "https://www.google.com/search?q=" + results.getText();
        WebView webView = findViewById(R.id.foodViewResults);
        webView.loadUrl(url);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
    }


}