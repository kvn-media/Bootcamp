package com.enigmacamp.excercise;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class kotakCek extends AppCompatActivity {

    CheckBox kotakCekMiring;
    CheckBox kotakCekTebal;
    TextView textViewHello;

    boolean miring = false, tebal = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kotak_cek);

        kotakCekMiring = (CheckBox) findViewById(R.id.checkBoxMiring);
        kotakCekTebal = (CheckBox) findViewById(R.id.checkBoxTebal);
        textViewHello = (TextView) findViewById(R.id.textViewHello);

        kotakCekMiring.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
                miring = arg1;

                if (miring && tebal)
                    textViewHello.setTypeface(null, Typeface.BOLD_ITALIC);
                else
                    if (miring)
                        textViewHello.setTypeface(null, Typeface.ITALIC);
                    else
                        if (tebal)
                            textViewHello.setTypeface(null, Typeface.BOLD);
                        else
                            textViewHello.setTypeface(null, Typeface.NORMAL);
            }
        });

        kotakCekTebal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
                tebal = arg1;

                if (miring && tebal)
                    textViewHello.setTypeface(null, Typeface.ITALIC);
                else
                    if (miring)
                        textViewHello.setTypeface(null, Typeface.ITALIC);
                    else
                        if (tebal)
                            textViewHello.setTypeface(null, Typeface.BOLD);
                        else
                            textViewHello.setTypeface(null, Typeface.NORMAL);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}