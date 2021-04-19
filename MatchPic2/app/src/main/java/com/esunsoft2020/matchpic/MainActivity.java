package com.esunsoft2020.matchpic;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
//
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.InterstitialAd;
//import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity {

    AlertDialog dialog;
    AlertDialog.Builder builder, builder2, builder3;
    ImageView[] ivs = new ImageView[5];
    ImageView ivString;
    int[] imgs = new int[]{R.drawable.a_ele,R.drawable.a_frog,R.drawable.a_lion,R.drawable.a_monkey,R.drawable.a_pig};
//    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=0 ; i<ivs.length ; i++){
            ivs[i] = findViewById(R.id.iv01+i);
        }
        ivString= findViewById(R.id.ivString);
//
//        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
//
//        interstitialAd = new InterstitialAd(this);
//        interstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
//        interstitialAd.loadAd(new AdRequest.Builder().build());
//

    }

    public void howToPlay(View view) {
        builder = new AlertDialog.Builder(this);
        builder.setTitle("게임설명");
        builder.setMessage("matchPic이란 게임은 동물이 나올거야.하단에 있는 단어와 터치한 동물이 일치하면 이기는 거지!!\nGame Start 를 눌러 시작해봐! ");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                player = MediaPlayer.create(MainActivity.this,R.raw.s_select);
                player.start();
                makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
            }
        });
        dialog = builder.create();
        dialog.show();
    }

    ArrayList<Integer> arr = new ArrayList<>();

    public void start(View view) {

//        if(interstitialAd.isLoaded()){
//            interstitialAd.show();
//        } else{
//            makeText(this, "The interstitial wasn't loaded yet.", Toast.LENGTH_SHORT).show();
//        }

        builder2 = new AlertDialog.Builder(this);
        builder2.setMessage("시작하려면 OK를 누르세요!");
        builder2.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                makeText(MainActivity.this, "Game Start!!", Toast.LENGTH_SHORT).show();
                player = MediaPlayer.create(MainActivity.this,R.raw.s_sijak);
                player.start();
                retry();
            }
        });

        dialog = builder2.create();
        dialog.show();

    }

    public void retry(){

        arr.clear();
        for(int i=0 ; i<ivs.length ; i++){
            arr.add(i);
        }

        Collections.shuffle(arr);

        for(int i=0 ; i<ivs.length ; i++){
            ivs[i].setTag(arr.get(i));
            ivs[i].setImageResource(imgs[arr.get(i)]);
        }

        Random rnd = new Random();
        matchNum=rnd.nextInt(4)+"";
        ivString.setTag(matchNum);
        ivString.setImageResource(R.drawable.b_elephant+Integer.parseInt(matchNum));

    }//retry method...

    String matchNum;
    MediaPlayer player;

    public void match(View v) {
        String t = v.getTag().toString();

        if(t.equals(matchNum)){
            Toast.makeText(this,"잘했어",Toast.LENGTH_SHORT).show();
            player = MediaPlayer.create(this,R.raw.s_goodjob);
            player.start();
            retry();

        } else {
            makeText(this, "다시 잘봐!", Toast.LENGTH_SHORT).show();
            player = MediaPlayer.create(this,R.raw.s_again);
            player.start();

        }
    }//match method...

}