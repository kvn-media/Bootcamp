package com.enigmacamp.excercise;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class dialog2 extends AppCompatActivity {
    Button tombol;

    String[] daftarMakanan = {
        "Soto Kudus",
        "Sate Kerbau",
        "Garang Asem",
        "Opor Ceker Ayam",
        "Nasi Kebuli"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog2);

        tombol = (Button) findViewById(R.id.buttonDialog2);
        tombol.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                AlertDialog.Builder kotakDialog = new AlertDialog.Builder(dialog2.this);
                kotakDialog.setCancelable(false);
                kotakDialog.setTitle("Daftar Makanan");

                kotakDialog.setItems(daftarMakanan, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getApplication(), "Anda memilih " + daftarMakanan[id],
                                Toast.LENGTH_LONG).show();
                    }
                });

                kotakDialog.create().show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}

