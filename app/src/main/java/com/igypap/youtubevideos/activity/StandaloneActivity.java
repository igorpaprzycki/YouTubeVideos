package com.igypap.youtubevideos.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;
import com.igypap.youtubevideos.R;

public class StandaloneActivity extends AppCompatActivity
        implements View.OnClickListener {

    private String GOOGLE_API_KEY = "AIzaSyBiAP0jLSDvJiSJp03qXlKWgXJWVOiNLyY";
    private String YOUTUBE_VIDEO_ID = "rnWAPG6wkco";
    private String YOTUBE_PLAYLIST = "PL66120AF13865BBF9";

    //    @BindView(R.id.btn_play_video)
    Button mBtnPlayVideo;
    //    @BindView(R.id.btn_playlist)
    Button mBtnPlayPlaylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone);
//        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mBtnPlayVideo = (Button) findViewById(R.id.btn_play_video);
        mBtnPlayPlaylist = (Button) findViewById(R.id.btn_playlist);

        mBtnPlayVideo.setOnClickListener(this);
        mBtnPlayPlaylist.setOnClickListener(this);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }


    //    @OnClick({R.id.btn_play_video, R.id.btn_playlist})
    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn_play_video:
                intent = YouTubeStandalonePlayer
                        .createVideoIntent(this, GOOGLE_API_KEY, YOUTUBE_VIDEO_ID);
                break;

            case R.id.btn_playlist:
                intent = YouTubeStandalonePlayer
                        .createPlaylistIntent(this, GOOGLE_API_KEY, YOTUBE_PLAYLIST);
                break;
            default:
        }
        if (intent != null) {
            startActivity(intent);
        }
    }

}
