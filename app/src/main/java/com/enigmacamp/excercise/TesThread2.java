package com.enigmacamp.excercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class TesThread2 extends TesThread {

    final static int JUM_DATA = 1000000;

    Button tombolProses, tombolInfo;
    ProgressBar progressBar;

    int pencacah = 0;
    int jumlahDiklik = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tes_thread);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setMax(JUM_DATA);

        tombolProses = (Button) findViewById(R.id.button1);
        tombolInfo = (Button) findViewById(R.id.button2);

        tombolProses.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Thread threadProses = new Thread(new Runnable() {
                    public void run() {
                        proses();
                    }
                });

                threadProses.start();
            }
        });

        tombolInfo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                jumlahDiklik++;

                Toast.makeText(getApplication(),
                        "Jumlah diklik: " + String.valueOf(jumlahDiklik) + " kali. " +
                                "Nilai pencacah: " + String.valueOf(pencacah) + " kali. ",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void proses() {
        pencacah = 0;

        for (pencacah = 1; pencacah < JUM_DATA; pencacah++) {
            double nilai = Math.cosh(pencacah / JUM_DATA);

            progressBar.setProgress(pencacah);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}