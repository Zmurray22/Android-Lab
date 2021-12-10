package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.widget.MediaController;
import android.widget.VideoView;

public class SongActivity extends AppCompatActivity {
    private VideoView vidView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar

        setContentView(R.layout.activity_song);


        vidView = (VideoView) findViewById(R.id.vidView);
        vidView.setMediaController(new MediaController(this)); //add media controller
        Uri video = Uri.parse("android.resource://" +getPackageName()+ "/"+ R.raw.star_wars_song);
        vidView.setVideoURI(video);
        vidView.setZOrderOnTop(true); //don't merge video with other widgets

    }

    protected void onResume() {
        super.onResume();
        vidView.start();
    }
    protected void onPause() {
        vidView.stopPlayback();
        super.onPause();
    }
}