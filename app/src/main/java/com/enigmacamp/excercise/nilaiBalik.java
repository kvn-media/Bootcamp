package com.enigmacamp.excercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class nilaiBalik extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nilai_balik);

        Button tombolKirim = (Button) findViewById(R.id.buttonKirim);
        tombolKirim.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                TextView textNama = (TextView) findViewById(R.id.editTextNama);
                Intent intent = new Intent();
                intent.setData(Uri.parse(textNama.getText().toString()));
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}