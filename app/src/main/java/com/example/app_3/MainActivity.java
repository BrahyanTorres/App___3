package com.example.app_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button goo, llama, alar, cam, email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goo = findViewById(R.id.btnGoole);
        llama = findViewById(R.id.btnLlama);
        alar = findViewById(R.id.btnAlarm);
        cam = findViewById(R.id.btnCamara);
        email = findViewById(R.id.btnEmail);

        goo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irGooogle = new Intent(Intent.ACTION_VIEW);
                irGooogle.setData(Uri.parse("http://www.google.com"));
                startActivity(irGooogle);

            }
        });
        llama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Llamar = new Intent(Intent.ACTION_DIAL);
                Llamar.setData(Uri.parse("tel:3004988487"));
                    startActivity(Llamar);
                }


        });

       alar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                        .putExtra(AlarmClock.EXTRA_HOUR, 20)
                        .putExtra(AlarmClock.EXTRA_MINUTES, 8);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }

        });
        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent camara = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (camara.resolveActivity(getPackageManager()) != null) {
                    startActivity(camara);
                }


            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Correo= new
                Intent(Intent.ACTION_SEND);
                Correo.setData(Uri.parse("mailto"));
                Correo.setType("text/plain");
                Correo.putExtra(Intent.EXTRA_EMAIL, new String[]{"brahyan.ray9@gmail.com"});
                Correo.putExtra(Intent.EXTRA_SUBJECT, "USANDO LA APP");
                Correo.putExtra(Intent.EXTRA_TEXT, "Hola enviando comprobacion de la appa");

                if(Correo.resolveActivity(getPackageManager())!= null){
                    startActivity(Intent.createChooser(Correo,"title:Send Email"));
                }

            }
        });


    }
}


