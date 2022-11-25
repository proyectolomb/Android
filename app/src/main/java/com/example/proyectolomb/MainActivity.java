package com.example.proyectolomb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String usuario;
    private String contrasena;
    private boolean logeado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void iniciarSesion(View view){
        EditText etText;
        etText=(EditText)findViewById(R.id.tbUsuario);
        usuario= etText.getText().toString();
        etText=findViewById(R.id.tbContrasena);
        contrasena=etText.getText().toString();
        logeado=comprobarCredenciales();

        if (logeado) {
            startActivity(new Intent(this, Principal_activity.class));
        }
    }
    private boolean comprobarCredenciales(){
        if(usuario.equals("patricia")&&contrasena.equals("patricia")){
            return true;
        }
        return false;
    }
}