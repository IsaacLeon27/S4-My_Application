package com.iwalnexus.tsn.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textoprimero = findViewById(R.id.textView);
        final TextView textosegundo = findViewById(R.id.textView2);
        constraintLayout = findViewById(R.id.MainLayout);


        Button btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /// Toast.makeText(MainActivity.this,"Cliked", Toast.LENGTH_LONG).show();

                textoprimero.setText("El boton fue presionado");

                textosegundo.setText("Genial!!!");

                Snackbar snackbar = Snackbar.make(constraintLayout,"Este es in Snackbar", Snackbar.LENGTH_LONG);
                snackbar.show();

            }
        });

        Button go = findViewById(R.id.buttonIntent);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityNumero2.class);
                intent.putExtra("web", "www.google.com");
                intent.putExtra("tel", "123456");

                startActivity(intent);
            }
        });




    }





}
