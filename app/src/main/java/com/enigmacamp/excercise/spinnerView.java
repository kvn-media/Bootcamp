package com.enigmacamp.excercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class spinnerView extends AppCompatActivity {

    Spinner spinnerBuah;

    String[] daftarBuah = {
            "Apel",
            "Belimbing",
            "Melon",
            "Nanas",
            "Pisang",
            "Tidak ada"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_view);

        spinnerBuah = (Spinner) findViewById(R.id.spinnerBuah);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, daftarBuah);
        spinnerBuah.setAdapter(adapter);

        spinnerBuah.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                int indeks = arg0.getSelectedItemPosition();
                Toast.makeText(getApplication(),
                        "Anda memilih " + daftarBuah[indeks],
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}