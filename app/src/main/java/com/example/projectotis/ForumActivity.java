package com.example.projectotis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ForumActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forum);

        ImageButton btnHome = (ImageButton) findViewById(R.id.btnHome);


        WebView myWebView = (WebView) findViewById(R.id.redditForum);
        //myWebView.loadUrl("https://www.reddit.com/r/projectotisforum/");
        myWebView.loadUrl("https://www.proboards.com/");



        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ForumActivity.this, MainActivity.class));

            }
        });




    }
}
