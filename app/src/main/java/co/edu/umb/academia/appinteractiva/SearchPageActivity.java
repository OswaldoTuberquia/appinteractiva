package co.edu.umb.academia.appinteractiva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.PrintWriter;
import java.io.StringWriter;

public class SearchPageActivity extends AppCompatActivity {

    private EditText url;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page);
        url = (EditText) findViewById(R.id.txtUrl);
    }

    public void opUploadUrl(View view){
        try{
            String urlType = url.getText().toString().trim();
            if(!urlType.isEmpty() && urlType.trim().length() > 10){
                Intent appView = new Intent(getApplicationContext(),AppViewActivity.class);
                appView.putExtra("cUrl",urlType);
                startActivity(appView);
            }else{
                Toast.makeText(this, "Ingrese una URL Valida", Toast.LENGTH_LONG).show();
            }
        }catch (Exception ex){
            StringWriter errors = new StringWriter();
            ex.printStackTrace(new PrintWriter(errors));
            Toast.makeText(this, errors.toString(), Toast.LENGTH_LONG).show();
        }
    }
    public void backMenuFromSearch(View view){
        Intent back = new Intent(getApplicationContext(),MenuActivity.class);
        startActivity(back);
    }
}