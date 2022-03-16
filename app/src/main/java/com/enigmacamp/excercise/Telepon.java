package com.enigmacamp.excercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Telepon extends AppCompatActivity {

    EditText editTextTelepon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telepon);

        editTextTelepon = (EditText) findViewById(R.id.editTextTelepon);
        Button tombolPanggil = (Button) findViewById(R.id.buttonTelepon);
        tombolPanggil.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent in = new Intent(
                        Intent.ACTION_DIAL, Uri.parse("tel:" +
                        editTextTelepon.getText().toString()));
                startActivity(in);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}