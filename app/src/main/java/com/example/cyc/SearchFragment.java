package com.example.cyc;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SearchFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_main3,container,false);
    }
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
