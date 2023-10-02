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


    Button goo, llama, alar, cam, ytb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goo = findViewById(R.id.btnGoole);
        llama = findViewById(R.id.btnLlama);
        alar = findViewById(R.id.btnAlarm);
        cam = findViewById(R.id.btnCamara);
        ytb = findViewById(R.id.btnYoutube);

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
                Intent llamar = new Intent(Intent.ACTION_CALL, Uri.parse("3004988487"));
                if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)!=
                        PackageManager.PERMISSION_GRANTED)
                    return;
                    startActivity(llamar);
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
                Intent abrirCamara= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (abrirCamara.resolveActivity(getPackageManager()) != null){
                    startActivity(abrirCamara);
                }


            }
        });

        ytb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irYoutube = new Intent(Intent.ACTION_VIEW);
                irYoutube.setData(Uri.parse("http://www.youtube.com"));
                startActivity(irYoutube);

            }
        });


    }
}


