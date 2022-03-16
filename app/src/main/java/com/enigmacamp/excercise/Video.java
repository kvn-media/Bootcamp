package com.enigmacamp.excercise;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class Video extends AppCompatActivity {

    Button tombolVideo;
    VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        video = (VideoView) findViewById(R.id.videoViewTest);
        tombolVideo = (Button) findViewById(R.id.buttonVideo);
        tombolVideo.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.R)
            @Override
            public void onClick(View arg0) {
                if (!video.isPlaying()) {
                    tombolVideo.setText("Stop");
                    video.setVideoPath(Environment.getStorageDirectory() + "/Penjelasan MPS Distributing.mp4");

                    video.start();
                }
                else {
                    tombolVideo.setText("Play");
                    video.pause();
                }
            }
        });

        video.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            public void onCompletion(MediaPlayer arg0) {
                tombolVideo.setText("Play");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}