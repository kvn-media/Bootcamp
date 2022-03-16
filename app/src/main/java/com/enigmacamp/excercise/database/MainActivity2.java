package com.enigmacamp.excercise.database;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.enigmacamp.excercise.R;
import com.enigmacamp.excercise.database.Dbase;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    Dbase db;
    Button tombolSimpan;
    EditText editNama, editTanggal;
    CheckBox cekGender;
    ListView listViewData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        db = new Dbase(this);

        editNama = (EditText) findViewById(R.id.editTextNama);
        editTanggal = (EditText) findViewById(R.id.editTextTglLahir);
        cekGender = (CheckBox) findViewById(R.id.checkBoxPria);
        listViewData = (ListView) findViewById(R.id.listViewDb);

        tombolSimpan = (Button) findViewById(R.id.buttonSimpan);
        tombolSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                db.open();
                db.insertData(editNama.getText().toString(),
                        cekGender.isChecked(),
                        editTanggal.getText().toString());
                db.close();

                Toast.makeText(getBaseContext(),
                        "Data telah disimpan",
                        Toast.LENGTH_SHORT).show();
                editNama.setText("");
                cekGender.setChecked(false);
                editTanggal.setText("");

                tampilkanData();
            }
        });
        tampilkanData();
    }
    public void tampilkanData() {
        db.open();
        Cursor c = db.getAllData();

        ArrayList<String> larik = new ArrayList<String>();

        if (c.moveToFirst()) {
            do {
                int idArtis = c.getInt(0);
                String namaArtis = c.getString(1);
                int genderArtis = c.getInt(2);
                String tglLahir = c.getString(3);

                String kelamin;
                if (genderArtis == 1)
                    kelamin = "Pria";
                else
                    kelamin = "Wanita";

                larik.add(Integer.toString(idArtis) + ": " +
                        namaArtis + " (" + kelamin + ") - " +
                        tglLahir);
            }while (c.moveToFirst());
        }
        db.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                larik);
        listViewData.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}