package com.mrhi2020.ex93youtubeplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.os.Bundle;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

public class MainActivity extends AppCompatActivity {

    YouTubePlayerFragment youTubeFragment;
    YouTubePlayerFragment youTubeFragment2;

    YouTubeThumbnailView youTubeThumbnailView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //xml에 있는 YouTubePlayerFragment 참조하기
        FragmentManager fragmentManager= getFragmentManager();
        youTubeFragment= (YouTubePlayerFragment)fragmentManager.findFragmentById(R.id.youtubeFragment);

        //첫번째 파라미터 : 식별자. <-이 이름이 같으면 Player가 같은 뷰라고 생각해서 같은 내용을 보여줌
        youTubeFragment.initialize("first", new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                //유투브 비디오의 id를 지정( url 아님!!! )
                youTubePlayer.cueVideo("yNvjituGDLQ");//로딩이 완료되어도 자동실행되지는 않음
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });


        youTubeFragment2= (YouTubePlayerFragment)fragmentManager.findFragmentById(R.id.youtubeFragment2);
        youTubeFragment2.initialize("second", new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("u7f5oeIXi-s");//로딩완료되면 바로 재생
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });


        youTubeThumbnailView= findViewById(R.id.youtubeThumbnail);
        youTubeThumbnailView.initialize("thumb", new YouTubeThumbnailView.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader youTubeThumbnailLoader) {
                youTubeThumbnailLoader.setVideo("I-wwKbFkYhg");
            }

            @Override
            public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });

    }
}