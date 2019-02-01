package com.landa.miprimeraapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView te_Register;
    private Button Login;
    EditText user, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=findViewById(R.id.et_username);
        password=findViewById(R.id.et_password);


        te_Register = findViewById(R.id.tv_Register);
        te_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this, Registro.class);
                startActivity(i);

            }
        });

        Login = findViewById(R.id.bt_buttonLog);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n= new Intent(MainActivity.this, perfil.class);
                n.putExtra("nombre", user.getText().toString());
                n.putExtra("password",password.getText().toString());
                startActivity(n);
            }
        });
    }

    /** Cierra la actividad anterior*/

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder= new AlertDialog.Builder(this)
                .setTitle("SALIR?")
                .setMessage("Desea Salir de la aplicación?")
                .setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                })
                .setPositiveButton("CONFIRMAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.super.onBackPressed();


                    }
                });

        builder.show();
    }

    @Override
    protected void onPause() {
        Log.e("LifeCicle", "onPause");
        super.onPause();

    }
}
