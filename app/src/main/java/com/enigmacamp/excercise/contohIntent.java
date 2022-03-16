package com.enigmacamp.excercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class contohIntent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contoh_intent);

        Button tombolKeHal2 = (Button) findViewById(R.id.buttonKeHalDua);
        tombolKeHal2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(arg0.getContext(),
                        HalamanDua.class);

                Bundle data = new Bundle();
                data.putString("Salam", "Sukses selalu!");
                intent.putExtras(data);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}