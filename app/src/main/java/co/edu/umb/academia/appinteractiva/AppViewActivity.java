package co.edu.umb.academia.appinteractiva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class AppViewActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_view);
        Intent receiver = getIntent();
        webView = (WebView) findViewById(R.id.webViewId);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl(receiver.getStringExtra("cUrl"));
    }

    public void backMenuFromWebView(View view){
        Intent back = new Intent(getApplicationContext(),MenuActivity.class);
        startActivity(back);
    }

}