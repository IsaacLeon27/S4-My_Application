package com.iwalnexus.tsn.myapplication;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class ActivityNumero2 extends AppCompatActivity {

    private EditText web;
    private EditText tel;
    private Button bWeb;
    private Button bTel;

    String webA1;
    String telA1;

    static final int CODETEL = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numero2);

        web = findViewById(R.id.web);
        tel= findViewById(R.id.tel);
        bWeb = findViewById(R.id.buttonWeb);
        bTel = findViewById(R.id.buttonTel);

        Bundle datos = this.getIntent().getExtras();
        webA1 = datos.getString("web");
        telA1 = datos.getString("tel");

        web.setText(webA1);
        tel.setText(telA1);

        bWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String urlWeb = web.getText().toString();

                if(urlWeb != null){

                    if(!urlWeb.contains("http")) {
                        urlWeb = "http://" +urlWeb;
                    }

                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlWeb));
                    startActivity(intent);
                }

            }
        });

        bTel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(tel.getText() != null){

                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){

                        requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, CODETEL);

                    } else {

                        Toast.makeText(ActivityNumero2.this, "No tiene permiso", Toast.LENGTH_LONG).show();

                    }
                }

            }
        });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode){
            case CODETEL:
                String permisos = permissions[0];
                int result = grantResults[0];

                if(permisos.equals(Manifest.permission.CALL_PHONE)){
                    if(result == PackageManager.PERMISSION_GRANTED){
                        String telefono = tel.getText().toString();
                        Intent intentLlamar = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+telefono));

                        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                            return;
                        }

                        startActivity(intentLlamar);
                    } else {

                        Toast.makeText(ActivityNumero2.this, "No tiene permiso", Toast.LENGTH_LONG).show();
                    }
                }

        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
