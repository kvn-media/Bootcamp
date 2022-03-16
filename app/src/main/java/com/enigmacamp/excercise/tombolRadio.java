package com.enigmacamp.excercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.widget.RadioGroup;
import android.widget.TextView;

public class tombolRadio extends AppCompatActivity {

    RadioGroup radioPosisi;
    TextView textViewHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tombol_radio);

        textViewHello = (TextView) findViewById(R.id.textViewHello);

        radioPosisi = (RadioGroup) findViewById(R.id.radioGroupPosisi);
        radioPosisi.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                switch (arg1) {
                    case R.id.radioKiri:
                        textViewHello.setGravity(Gravity.LEFT);
                        break;
                    case R.id.radioTengah:
                        textViewHello.setGravity(Gravity.CENTER);
                        break;
                    case R.id.radioKanan:
                        textViewHello.setGravity(Gravity.RIGHT);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}