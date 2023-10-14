package co.edu.umb.academia.appinteractiva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ConfirmationActivity extends AppCompatActivity {

    private TextView txtname,txtlastname, txtage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        txtname = (TextView) findViewById(R.id.txtConfirmationName);
        txtlastname = (TextView) findViewById(R.id.txtConfirmationLastname);
        txtage = (TextView) findViewById(R.id.txtConfirmationAge);

        Intent receiver = getIntent();
        txtname.setText("Nombres: "+receiver.getStringExtra("cNombres"));
        txtlastname.setText("Apellidos: "+receiver.getStringExtra("cApellidos"));
        txtage.setText("Edad: "+receiver.getStringExtra("cEdad"));
    }

    public void backToMenuFromConfirmation(View view){
        Intent back = new Intent(getApplicationContext(),MenuActivity.class);
        startActivity(back);
    }
}