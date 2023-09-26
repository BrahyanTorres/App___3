package com.example.app_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button goo, llama, alar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goo = findViewById(R.id.goole);
        llama = findViewById(R.id.llama);
        alar = findViewById(R.id.alarm);

        goo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irGooogle = new Intent(Intent.ACTION_VIEW);
                irGooogle.setData(Uri.parse("http://www.google.com"));
                startActivity(irGooogle);


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

    }

}


