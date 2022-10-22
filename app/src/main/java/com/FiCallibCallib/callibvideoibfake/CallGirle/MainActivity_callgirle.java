package com.FiCallibCallib.callibvideoibfake.CallGirle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;

import com.FiCallibCallib.callibvideoibfake.Ads_admob.Admob;
import com.FiCallibCallib.callibvideoibfake.R;
import com.FiCallibCallib.callibvideoibfake.Video.videoplayer_activity;
import com.FiCallibCallib.callibvideoibfake.functions;
import com.FiCallibCallib.callibvideoibfake.my_own_ads_2021;
import com.mikhaellopez.circularimageview.CircularImageView;

public class MainActivity_callgirle extends AppCompatActivity {


    CircularImageView circularImageView ;
    LinearLayout nextActivityCalling ;
    public Admob admob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_girle);

         admob = new Admob(this);
        admob.LoadInters();


        circularImageView = findViewById(R.id.circule_Image);
        nextActivityCalling = findViewById(R.id.Lt_next_calling);


        nextActivityCalling.setOnClickListener(View ->{

            StartCalling();
        });


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                circularImageView.setAnimation(LoadRotation());

            }
        },100);

        my_own_ads_2021.showbanner(this);
        my_own_ads_2021.showbanner2(this);
    }

    private void StartCalling() {

        admob.ShowInters(new Admob.AdFinishee() {
            @Override
            public void OnAdFinishid() {

                Intent into = new Intent(getApplicationContext(), videoplayer_activity.class);
                startActivity(into);
                finish();
            }
        });



    }

    private Animation LoadRotation() {
        RotateAnimation animation = new RotateAnimation
                (0,360 , Animation.RELATIVE_TO_SELF,
                        0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        animation.setInterpolator(new LinearInterpolator());
        animation.setDuration(10000);
        animation.setRepeatCount(Animation.INFINITE);


        return animation ;
    }

}