package com.enigmacamp.excercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout tataletak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tataletak = (ConstraintLayout) findViewById(R.id.constraintLayoutMenu);
        Button tombol = (Button) findViewById(R.id.buttonMenu);
        registerForContextMenu(tombol);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Menu Konteks - Warna Latar Belakang");
        menu.add(0, v.getId(), 0, "Biru");
        menu.add(0, v.getId(), 0, "Merah");
        menu.add(0, v.getId(), 0, "Putih");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle() == "Biru")
            ubahWarna(Color.BLUE);
        else
            if (item.getTitle() == "Merah")
                ubahWarna(Color.RED);
        else
            if (item.getTitle() == "Putih")
                ubahWarna(Color.WHITE);
            else
                return false;

            return true;
    }

    public void ubahWarna(int warna) {
        tataletak.setBackgroundColor(warna);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}