package com.example.web;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText url_text;
    private Button button_sbm;
    private WebView browser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openUrl();
    }

    public void openUrl(){
        button_sbm = findViewById(R.id.button);
        url_text = findViewById(R.id.text);
        browser = findViewById(R.id.webView);
        button_sbm.setOnClickListener(
                new View.OnClickListener() {
                    @SuppressLint("SetJavaScriptEnabled")
                    @Override
                    public void onClick(View v) {
                        String url = url_text.getText().toString();
                        browser.getSettings().setLoadsImagesAutomatically(true);
                        //browser.getSettings().setJavaScriptEnabled(true);
                        browser.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                        browser.loadUrl(url);
                    }
                }
        );
    }
}
