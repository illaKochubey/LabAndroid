package com.example.user.a4lab;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import android.net.Uri;


import android.widget.MediaController;



public class VideoActivity extends AppCompatActivity implements View.OnClickListener{
  public VideoView videoPlayer;
   public VideoView videoView1;
    RadioButton first,second;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

    }

    @Override
    public void onClick(View v) {

    }
    public void Video(String Name)
    {






    }
    public void backClick(View v) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void play(View view){

        first = (RadioButton)findViewById(R.id.first);
        second = (RadioButton)findViewById(R.id.second);

        if(first.isChecked()) {
            videoPlayer =  (VideoView)findViewById(R.id.videoPlayer);
            Uri  myVideoUri= Uri.parse( "android.resource://" + getPackageName() + "/" + R.raw.home);

            videoPlayer.setVideoURI(myVideoUri);
            MediaController mediaController = new MediaController(this);
            videoPlayer.setMediaController(mediaController);
            mediaController.setMediaPlayer(videoPlayer);

            videoView1 =  (VideoView)findViewById(R.id.videoView1);
            videoView1.setVideoPath("http://video.ch9.ms/ch9/507d/71f4ef0f-3b81-4d2c-956f-c56c81f9507d/AndroidEmulatorWithMacEmulator.mp4");
            MediaController mediaController1 = new MediaController(this);
            videoView1.setMediaController(mediaController1);
            mediaController1.setMediaPlayer(videoView1);

        }
        else if(second.isChecked()){
            videoPlayer =  (VideoView)findViewById(R.id.videoPlayer);
            Uri  myVideoUri= Uri.parse( "android.resource://" + getPackageName() + "/" + R.raw.village);

            videoPlayer.setVideoURI(myVideoUri);
            MediaController mediaController = new MediaController(this);
            videoPlayer.setMediaController(mediaController);
            mediaController.setMediaPlayer(videoPlayer);

            videoView1 =  (VideoView)findViewById(R.id.videoView1);
            videoView1.setVideoPath("http://video.ch9.ms/ch9/507d/71f4ef0f-3b81-4d2c-956f-c56c81f9507d/AndroidEmulatorWithMacEmulator.mp4");
            MediaController mediaController1 = new MediaController(this);
            videoView1.setMediaController(mediaController1);
            mediaController1.setMediaPlayer(videoView1);
        }



        videoPlayer.start();videoView1.start();
    }
    public void pause(View view){
        videoPlayer.pause();     videoView1.pause();
    }
    public void stop(View view){
        videoPlayer.stopPlayback();
        videoPlayer.resume();
        videoView1.stopPlayback();
        videoView1.resume();
    }


}
