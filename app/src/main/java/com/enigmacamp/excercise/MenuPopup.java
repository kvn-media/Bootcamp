package com.enigmacamp.excercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MenuPopup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pop_up);

        Button tombol = (Button) findViewById(R.id.buttonMenu);
        View.OnClickListener listener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(getBaseContext(), v);
                popup.getMenuInflater().inflate(R.menu.main, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(getBaseContext(),
                                "Pilihan Anda adalah : " +
                                        item.getTitle(),
                                Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });

                popup.show();
            }
        };

        tombol.setOnClickListener(listener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}