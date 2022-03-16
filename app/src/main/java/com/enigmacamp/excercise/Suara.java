package com.enigmacamp.excercise;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Suara extends AppCompatActivity {

    MediaPlayer mp;
    Button tombolSuara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suara);

        mp = MediaPlayer.create(this, R.raw.LikeFlamesMindaRyn);
        tombolSuara = (Button) findViewById(R.id.buttonSuara);
        tombolSuara.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (mp.isPlaying()) {
                    tombolSuara.setText("Play");
                }
                else {
                    tombolSuara.setText("Stop");
                    mp.start();
                }
            }
        });

        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            public void onCompletion(MediaPlayer arg0) {
                tombolSuara.setText("Play");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}