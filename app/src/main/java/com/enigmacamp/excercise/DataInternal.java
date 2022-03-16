package com.enigmacamp.excercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInternal extends AppCompatActivity {

    Button tombolSimpan;
    EditText nama, telepon;
    TextView dataTelepon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_internal);

        nama = (EditText) findViewById(R.id.editTextNama);
        telepon = (EditText) findViewById(R.id.editTextTelepon);
        dataTelepon = (TextView) findViewById(R.id.textViewData);

        tombolSimpan = (Button) findViewById(R.id.buttonSimpan);
        tombolSimpan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                byte[] bufferNama = new byte[30];
                byte[] bufferTelepon = new byte[15];

                salinData(bufferNama, nama.getText().toString());
                salinData(bufferTelepon, telepon.getText().toString());

                try {
                    FileOutputStream berkas =
                            openFileOutput("telepon.dat", MODE_APPEND);
                    DataOutputStream output = new DataOutputStream(berkas);

                    output.write(bufferNama);
                    output.write(bufferTelepon);

                    berkas.close();

                    Toast.makeText(getBaseContext(), "Data telah disimpan",
                            Toast.LENGTH_SHORT).show();
                }
                catch (IOException e) {
                    Toast.makeText(getBaseContext(),
                            "Kesalahan: " + e.getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
                tampilkanData();
            }
        });
        tampilkanData();
    }

    public void salinData(byte[] buffer, String data) {
        for (int i = 0; i < buffer.length; i++)
            buffer[i] = 0;

        for (int i = 0; i < data.length(); i++)
            buffer[i] = (byte) data.charAt(i);
    }

    public void tampilkanData() {
        try {
            FileInputStream berkas = openFileInput("telepon.dat");

            DataInputStream input = new DataInputStream(berkas);

            byte[] bufNama = new byte[30];
            byte[] bufTelepon = new byte[15];

            String infoData = "Data Telepon:\n";

            while (input.available() > 0) {
                input.read(bufNama);
                input.read(bufTelepon);

                String namaTeman = "";
                for (int i = 0; i < bufNama.length; i++)
                    namaTeman = namaTeman + (char) bufNama[i];

                String teleponTeman = "";
                for (int i = 0; i < bufTelepon.length; i++)
                    teleponTeman = teleponTeman + (char) bufTelepon[i];

                infoData = infoData + namaTeman + " - " +
                        teleponTeman + "\n";
            }

            dataTelepon.setText(infoData);
            berkas.close();
        }
        catch (IOException e) {
            Toast.makeText(getBaseContext(),
                    "Kesalahan:" + e.getMessage(),
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
