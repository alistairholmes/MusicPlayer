package com.example.android.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creates the MediaPlayer that will play track_1
        mediaPlayer = MediaPlayer.create(this, R.raw.track_1);

        //Initialize variable with id of play button
        Button playButton = (Button) findViewById(R.id.play_button);

        //Set OnClick Listener. Will start song when play button is clicked
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                // Set OnCompletion Listener. Check to see if the audio resource has finished playing
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        // Make a toast when song is complete
                        Toast toast = Toast.makeText(getApplicationContext(), "I'm Done.", Toast.LENGTH_LONG);
                        toast.show();
            }
        });


            }
        });

        //Initialize variable with id of pause button
        Button pauseButton = (Button) findViewById(R.id.pause_button);

        //Set OnClick Listener. Will pause song when pause button is clicked
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });

        //Initialize variable with id of play button
        Button resetButton = (Button) findViewById(R.id.reset_button);

        //Set OnClick Listener. Will start song when play button is clicked
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
            }
        });
    }
}

