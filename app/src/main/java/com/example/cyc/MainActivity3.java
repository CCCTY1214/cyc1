package com.example.cyc;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;
import android.widget.MediaController;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity{
    MediaPlayer ring;
    VideoView videoview;

    boolean musicPaused = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        videoview = (VideoView) findViewById(R.id.videoView);
        ring = MediaPlayer.create(MainActivity3.this, R.raw.pv1);



        Uri uri = Uri.parse("android.resource://" + getPackageName()
                + "/"+R.raw.pv1);
        videoview.setVideoURI(uri);
        MediaController controller = new MediaController(this);
        controller.setMediaPlayer(videoview);
        videoview.setMediaController(controller);

    }
    public void musicPause(View v) {
        if(ring.isPlaying() || musicPaused) {
            if (!musicPaused) {
                ring.pause();
                musicPaused = true;
            } else{
                ring.start();
                musicPaused = false;
            }
        }
    }
    public void musicStopStart(View v) {
        try {
            if (ring.isPlaying() || musicPaused){
                ring.stop();
                ring.prepare();
                musicPaused = false;
            }
            else{
                ring.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
