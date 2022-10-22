package com.FiCallibCallib.callibvideoibfake;

import android.content.Context;
import android.os.Handler;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
import com.r0adkll.slidr.model.SlidrInterface;

public class functions {

    public static  void lockSlide(SlidrInterface slidr) {
        slidr.lock();
    }

    public static void unlockSlide(SlidrInterface slidr) {
        slidr.unlock();
    }


    public static void skip_after5(Context context, LottieAnimationView loti, SlidrInterface slidr)
    {
        // LottieAnimationView loti = ((Activity)context).findViewById(R.id.animationView);
        lockSlide(slidr);
        loti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // Actions to do after 10 seconds

                loti.setAnimationFromUrl(config.leavematch_picture);
                unlockSlide(slidr);


                //   my_own_ads.ads_methode(context);

            }
        }, 5000);


    }


}
