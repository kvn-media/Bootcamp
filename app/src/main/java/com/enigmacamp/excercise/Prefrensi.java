package com.enigmacamp.excercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Prefrensi extends AppCompatActivity {

    final static String NAMA_FILE = "catatan";
    EditText editNama, editUsia;
    CheckBox cekPria;
    Button tombolSimpan, tombolHapus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prefrensi);

        tombolSimpan = (Button) findViewById(R.id.buttonSimpan);
        editNama = (EditText) findViewById(R.id.editTextNama);
        editUsia = (EditText) findViewById(R.id.editTextUsia);
        cekPria = (CheckBox) findViewById(R.id.checkBoxPria);
        tombolSimpan = (Button) findViewById(R.id.buttonSimpan);
        tombolHapus = (Button) findViewById(R.id.buttonHapus);

        bacaPreferensi();

        tombolSimpan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                SharedPreferences pref = getSharedPreferences(
                        NAMA_FILE, MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("nama", editNama.getText().toString());
                editor.putInt("usia", Integer.valueOf(
                        editUsia.getText().toString()));
                editor.putBoolean("pria", Boolean.valueOf(cekPria.isChecked()));
                editor.commit();
                Toast.makeText(getBaseContext(),
                        "Preferensi sudah disimpan", Toast.LENGTH_SHORT).show();
            }
        });

        tombolHapus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                SharedPreferences pref = getSharedPreferences(
                        NAMA_FILE, MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.clear();
                editor.commit();

                editNama.setText("");
                editUsia.setText("");
                cekPria.setChecked(false);
            }
        });
    }

        public void bacaPreferensi() {
            SharedPreferences pref = getSharedPreferences(
                    NAMA_FILE, MODE_PRIVATE);
            editNama.setText(pref.getString("nama", ""));

            int usia = pref.getInt("usia", 0);
            if (usia == 0)
                editUsia.setText("");
            else
                editUsia.setText(String.valueOf(usia));
            cekPria.setChecked(pref.getBoolean("pria", false));
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }
}
