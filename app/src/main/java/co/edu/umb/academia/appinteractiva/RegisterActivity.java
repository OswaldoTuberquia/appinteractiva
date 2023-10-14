package co.edu.umb.academia.appinteractiva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText txtNombres, txtApellidos, txtEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        txtNombres = (EditText) findViewById(R.id.nombresIdRegistro);
        txtApellidos = (EditText) findViewById(R.id.apellidosIdRegistro);
        txtEdad = (EditText) findViewById(R.id.edadRegistro);
    }

    public void opRegister(View view){
        String cNombres = txtNombres.getText().toString().trim();
        String cApellidos = txtApellidos.getText().toString().trim();
        String cEdad = txtEdad.getText().toString().trim();
        boolean isOkay = true;
        if(cNombres.isEmpty()){
            isOkay = false;
            Toast.makeText(this, "Digite Nombres", Toast.LENGTH_LONG).show();
        }
        if(cApellidos.isEmpty()){
            isOkay = false;
            Toast.makeText(this, "Digite Apellidos", Toast.LENGTH_LONG).show();
        }
        if(cEdad.isEmpty()){
            isOkay = false;
            Toast.makeText(this, "Digite Edad", Toast.LENGTH_LONG).show();
        }
        if(isOkay){
            Intent confirmation = new Intent(getApplicationContext(),ConfirmationActivity.class);
            confirmation.putExtra("cNombres",cNombres);
            confirmation.putExtra("cApellidos",cApellidos);
            confirmation.putExtra("cEdad",cEdad);
            startActivity(confirmation);
        }
    }

    public void backMenuFromRegister(View view){
        Intent back = new Intent(getApplicationContext(),MenuActivity.class);
        startActivity(back);
    }
}