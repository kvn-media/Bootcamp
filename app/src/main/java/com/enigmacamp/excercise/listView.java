package com.enigmacamp.excercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class listView extends AppCompatActivity {

    TextView textViewNegara, textViewIbukota;
    ListView listViewNegara;

    String[] daftarNegara;

    String[] daftarIbukota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        daftarNegara = getResources().getStringArray(R.array.negara);
        daftarIbukota = getResources().getStringArray(R.array.ibukota);

        listViewNegara = (ListView) findViewById(R.id.listViewNegara);
        textViewIbukota = (TextView) findViewById(R.id.textViewIbukota);
        textViewIbukota.setText("");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, daftarNegara);
        listViewNegara.setAdapter(adapter);

        listViewNegara.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String keterangan = "Negara" + daftarNegara[position] +
                        " beribukota di " + daftarIbukota[position];
                textViewIbukota.setText(keterangan);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}