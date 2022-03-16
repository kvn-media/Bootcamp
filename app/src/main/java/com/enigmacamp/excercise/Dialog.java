package com.enigmacamp.excercise;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Dialog extends AppCompatActivity {
    Button tombol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        tombol = (Button) findViewById(R.id.buttonDialog);
        tombol.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog.Builder kotakDialog = new AlertDialog.Builder(Dialog.this);
                kotakDialog.setCancelable(false);
                kotakDialog.setMessage("Anda akan menutup aplikasi ini?");
                kotakDialog.setTitle("Konfirmasi");

                kotakDialog.setPositiveButton("Ya", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {
                        Dialog.this.finish();
                    }
                });

                kotakDialog.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
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