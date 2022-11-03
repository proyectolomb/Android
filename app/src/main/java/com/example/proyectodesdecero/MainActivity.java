package com.example.proyectodesdecero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.botonLogin);
        btn.setBackgroundColor(getResources().getColor(R.color.white));
    }

    public void realizarLogin (View v){
        Intent intent = new Intent(this, Equipos.class);
        startActivity(intent);
    }
}