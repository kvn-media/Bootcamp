package com.enigmacamp.excercise.database;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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

import java.util.ArrayList;

public class Databse4 extends AppCompatActivity {

    Dbase db;
    Button tombolHapus;
    EditText editId;
    ListView listViewData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_databse4);

        db = new Dbase(this);

        editId = (EditText) findViewById(R.id.editTextId);
        listViewData = (ListView) findViewById(R.id.listViewDb);

        tombolHapus = (Button) findViewById(R.id.buttonHapus);
        tombolHapus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                db.open();

                Cursor c = db.getData(Long.parseLong(
                        editId.getText().toString()));
                if (!c.moveToFirst()) {
                    Toast.makeText(getBaseContext(),
                            "Data tidak ditemukan. Ganti Id lain",
                            Toast.LENGTH_SHORT).show();
                    db.close();
                    return;
                }

                String nama = c.getString(0);
                db.close();

                AlertDialog.Builder kotakDialog =
                        new AlertDialog.Builder(Databse4.this);
                kotakDialog.setCancelable(false);
                kotakDialog.setMessage("Anda akan menghapus data " +
                        nama + "?");
                kotakDialog.setTitle("Konfirmasi");

                kotakDialog.setPositiveButton("Ya",
                        new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int id) {
                                db.open();
                                db.deleteData(Long.parseLong(
                                        editId.getText().toString()));
                                db.close();

                                tampilkanData();
                            }
                        });
                kotakDialog.setNegativeButton("Tidak",
                        new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                kotakDialog.create().show();
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
                        namaArtis + " (" + kelamin + ") - " + tglLahir);
            } while (c.moveToNext());
        }
        else
            larik.add("Data tidak ditemukan!");

        db.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, larik);
        listViewData.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}