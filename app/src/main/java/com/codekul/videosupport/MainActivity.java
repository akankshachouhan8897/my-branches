package com.codekul.videosupport;

import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    MediaPlayer player =
            new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playAudio();
    }

    private void playAudio(){
        try {
            player.setDataSource(new File(Environment
                    .getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC),"a.mp3")
                    .getPath());
            player.prepare();
            player.start();
            player.setLooping(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void playVideo(){

        // #homework - show list of all videos from videos folder
        // and then on click of list item play that video

        final VideoView videoView =
                (VideoView) findViewById(R.id.videoView);
        videoView.setVideoPath(new File(Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES),"a.mp4")
                .getPath());
        videoView.seekTo(15000);
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

            }
        });
        MediaController controller = new MediaController(this);
        videoView.setMediaController(controller);
        videoView.start();
    }
}
