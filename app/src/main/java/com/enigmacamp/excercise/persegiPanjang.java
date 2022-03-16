package com.enigmacamp.excercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class persegiPanjang extends AppCompatActivity {

    EditText editPanjang, editLebar;
    TextView textKeliling;
    Button tombolHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persegi_panjang);

        editPanjang = (EditText) findViewById(R.id.editTextPanjang);
        editLebar = (EditText) findViewById(R.id.editTextLebar);
        textKeliling = (TextView) findViewById(R.id.textViewKeliling);
        tombolHitung = (Button) findViewById(R.id.buttonHitung);

        tombolHitung.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                double panjang = Double.parseDouble(editPanjang.getText().toString());
                double lebar = Double.parseDouble(editLebar.getText().toString());

                double keliling = 2 * (panjang + lebar);

                textKeliling.setText("Keliling = " + String.valueOf(keliling));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}