package com.landa.miprimeraapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class perfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

       Intent in= getIntent();
       String nombre= in.getExtras().getString("nombre");
       String Password= in.getExtras().getString("password");


        Toast.makeText(this,nombre+" "+Password, Toast.LENGTH_LONG).show();
    }



}
