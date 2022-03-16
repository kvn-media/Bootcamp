package com.enigmacamp.excercise.database;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.enigmacamp.excercise.R;
import com.enigmacamp.excercise.database.Dbase;

import org.w3c.dom.Text;

public class Database2 extends AppCompatActivity {

    Dbase db;
    Button tombolCari;
    EditText editId;
    TextView teksHasil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database2);

        db = new Dbase(this);

        editId = (EditText) findViewById(R.id.editTextId);
        teksHasil = (TextView) findViewById(R.id.textViewHasil);
        tombolCari = (Button) findViewById(R.id.buttonCari);
        tombolCari.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                tampilkanData();
            }
        });
    }

    public void tampilkanData() {
        db.open();
        Cursor c = db.getData(Long.parseLong(
                editId.getText().toString()));

        if (c.moveToFirst()) {
            String namaArtis = c.getString(0);
            int genderArtis = c.getInt(1);
            String tglLahir = c.getString(2);

            String kelamin;
            if (genderArtis == 1)
                kelamin = "Pria";
            else
                kelamin = "Wanita";

            teksHasil.setText("Id = " + editId.getText().toString() + "\n" +
                    namaArtis + "\n" + kelamin + "\n" + tglLahir);
        }
        else
            teksHasil.setText("Data tidak ditemukan!");
        db.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}