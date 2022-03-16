package com.enigmacamp.excercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class listView2 extends AppCompatActivity {

    ListView listViewMusik;

    String[] daftarMusik = {
            "Dangdut",
            "Jazz",
            "Keroncong",
            "Klasik",
            "R&B",
            "Rock",
            "Seriosa",
            "Slow"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view2);

        listViewMusik = (ListView) findViewById(R.id.listViewMusik);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, daftarMusik);
        listViewMusik.setAdapter(adapter);
        listViewMusik.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        listViewMusik.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String hasil = "";
                SparseBooleanArray terpilih = listViewMusik.getCheckedItemPositions();
                for (int i = 0; i < terpilih.size(); i++) {
                    int kunci = terpilih.keyAt(i);
                    boolean nilai = terpilih.get(kunci);
                    if (nilai)
                        hasil = hasil + daftarMusik[kunci] + " ";
                }

                Toast.makeText(getApplication(), hasil, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}