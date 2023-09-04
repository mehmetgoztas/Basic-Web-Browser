package com.gzt.web;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends Activity {

    private WebView webView;
    private EditText addressBar;
    private Button goButton;
    private Button newTabButton;
    private TextView currentTabTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.web_view);
        addressBar = (EditText) findViewById(R.id.address_bar);
        goButton = (Button) findViewById(R.id.go_button);
        newTabButton = (Button) findViewById(R.id.new_tab_button);
        currentTabTitle = (TextView) findViewById(R.id.current_tab_title);

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = addressBar.getText().toString();
                webView.loadUrl(url);
            }
        });

        newTabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //

            }


        });

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                currentTabTitle.setText(view.getTitle());
            }
        });
    }
}
