package com.landa.miprimeraapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class perfil extends AppCompatActivity {

    private RelativeLayout root_profile;
    private Button btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        root_profile = findViewById(R.id.profile_root);
        btnSalir = findViewById(R.id.btn_salir_profile);



        root_profile.setOnTouchListener(new View.OnTouchListener() {
            float xini = 0;
            float yfin=0;
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        xini= event.getX();
                        yfin=event.getY();
                        btnSalir.setText(event.getX() + ", " + event.getY());
                        break;

                    case MotionEvent.ACTION_MOVE:
                        btnSalir.setText("MOVE: " + event.getX() + "," + event.getY());
                        break;
                    case MotionEvent.ACTION_UP:
                        float deltaX= event.getX() - xini;
                        if(deltaX >500){
                            Intent intent=new Intent(perfil.this, MainProfile.class);
                            startActivity(intent);
                        }

                        if(deltaX< -500){
                            finish();
                        }
                        btnSalir.setText("DELTA: "+ deltaX);
                        break;

                }

                return true;
            }
        });

        Intent in = getIntent();
        String nombre = in.getExtras().getString("nombre");
        String Password = in.getExtras().getString("password");


        Toast.makeText(this, nombre + " " + Password, Toast.LENGTH_LONG).show();
    }


}
