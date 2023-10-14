package co.edu.umb.academia.appinteractiva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import java.io.PrintWriter;
import java.io.StringWriter;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progress;
    private TextView txtPercentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtPercentage = (TextView)findViewById(R.id.progressText);
        progress = (ProgressBar)findViewById(R.id.progressBar);
        progress.setMax(100);
        progress.setVisibility(View.VISIBLE);
        Thread banner = new Thread(){
            @Override
            public void run() {
                try{
                    int progressValue = 0;
                    while(progressValue < 100) {
                        sleep(1000);
                        progressValue+=20;
                        progress.setProgress(progressValue,true);
                        txtPercentage.setText(String.valueOf(progressValue)+"%");
                    }
                    Intent menu = new Intent(getApplicationContext(),MenuActivity.class);
                    startActivity(menu);
                }catch (Exception ex){
                    StringWriter errors = new StringWriter();
                    ex.printStackTrace(new PrintWriter(errors));
                    Toast.makeText(null, errors.toString(), Toast.LENGTH_LONG).show();
                }finally {
                    finish();
                }
            }
        };
        banner.start();
    }
}