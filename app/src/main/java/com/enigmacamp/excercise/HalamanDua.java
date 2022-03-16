package com.enigmacamp.excercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HalamanDua extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_kedua);

        TextView textHalDua = (TextView) findViewById(R.id.textViewHalDua);
        Bundle data = getIntent().getExtras();
        String info = data.getString("Salam");

        if (data !=null)
            textHalDua.setText(info);

        Button tombolKeHal1 = (Button) findViewById(R.id.buttonKeHalSatu);
        tombolKeHal1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
