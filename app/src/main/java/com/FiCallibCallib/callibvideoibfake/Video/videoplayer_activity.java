package com.FiCallibCallib.callibvideoibfake.Video;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.FiCallibCallib.callibvideoibfake.R;
import com.FiCallibCallib.callibvideoibfake.function;
import com.otaliastudios.cameraview.CameraView;
import com.otaliastudios.cameraview.controls.Facing;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrConfig;
import com.r0adkll.slidr.model.SlidrInterface;
import com.r0adkll.slidr.model.SlidrListener;
import com.r0adkll.slidr.model.SlidrPosition;

import java.util.ArrayList;
import java.util.Random;

public class videoplayer_activity extends AppCompatActivity {


    ArrayList<Videomodel>videomodels = new ArrayList<Videomodel>();
    ViewPager2 viewPager2 ;
    
    //video adapter 
    //ProgressBar progressBar;
    VideoView videoView;
    private CameraView camera, cameraFull;
    TextView titlee;
    ImageView switshCamera, switshMute, cashCamera, finishCall;

    Context context;
    boolean isplay = true;
    boolean switsh;
    private boolean disabledialog;
    public Dialog d ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_viewpager);

        d =   new Dialog(this);
        disabledialog = false;
        function.loading(this, d);

//        videomodels = new ArrayList<>();
//        viewPager2 = findViewById(R.id.viewpagerr);
       // viewPager2.setPagingEnabled(false);


        videomodels.add(new Videomodel("android.resource://" +getPackageName() + "/" + R.raw.vid1));
        videomodels.add(new Videomodel("android.resource://" +getPackageName() + "/" + R.raw.vid2));
        videomodels.add(new Videomodel("android.resource://" +getPackageName() + "/" + R.raw.vid3));
        videomodels.add(new Videomodel("android.resource://" +getPackageName() + "/" + R.raw.vid4));
        videomodels.add(new Videomodel("android.resource://" +getPackageName() + "/" + R.raw.vid5));
        videomodels.add(new Videomodel("android.resource://" +getPackageName() + "/" + R.raw.vid6));
        videomodels.add(new Videomodel("android.resource://" +getPackageName() + "/" + R.raw.vid7));
        videomodels.add(new Videomodel("android.resource://" +getPackageName() + "/" + R.raw.vid8));
        videomodels.add(new Videomodel("android.resource://" +getPackageName() + "/" + R.raw.vid9));
        videomodels.add(new Videomodel("android.resource://" +getPackageName() + "/" + R.raw.vid10));

        videoView =   findViewById(R.id.videoview);
        camera =   findViewById(R.id.camera);
        cameraFull =   findViewById(R.id.camerFullscreen);
        titlee =   findViewById(R.id.tv_conecting);
        switshCamera =   findViewById(R.id.switch_camera);
        switshMute =   findViewById(R.id.mute_sound);
        cashCamera =   findViewById(R.id.camer_cashcamera);
        finishCall =   findViewById(R.id.call_end);

        Random random_method = new Random();
        int index = random_method.nextInt(videomodels.size());
        Log.e( "init_videoview: ", videomodels.get(index).getVideourl());
        setVideoData(videomodels.get(index));
         init_videoview();

//        AdapterViedo adapter =new AdapterViedo(videomodels,this);
//        viewPager2.setAdapter(adapter);

       // Slidr.attach(this);
        setup_slide(this);
        d.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                videoView.start();
            }
        });

    }
    public void init_videoview() {


        switshCamera.setOnClickListener(View -> {

            if (isplay) {
                camera.open();
                camera.setFacing(Facing.BACK);
                switshCamera.setImageResource(R.drawable.ic_camera);
                isplay = false;
            } else {
                camera.open();
                camera.setFacing(Facing.FRONT);
                switshCamera.setImageResource(R.drawable.ic_camera_switsh);
                isplay = true;
            }

        });
        switshMute.setOnClickListener(View -> {

            if (switsh == true) {

                switshMute.setImageResource(R.drawable.ic_mute);
                switsh = false;
            } else {
                switshMute.setImageResource(R.drawable.ic_vocal);
                switsh = true;
            }

        });
        cashCamera.setOnClickListener(View -> {
            if (switsh == true) {
                camera.open();
                cashCamera.setImageResource(R.drawable.ic_videocalling);
                camera.setVisibility(android.view.View.VISIBLE);
                switsh = false;
            } else {

                cashCamera.setImageResource(R.drawable.ic_cmera_cashed);
                camera.setVisibility(android.view.View.GONE);
                switsh = true;
            }
        });

        finishCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    //function to setup slidr
    public void setup_slide(Context context)
    {
        SlidrConfig config2 = new SlidrConfig.Builder()
                .primaryColor(context.getResources().getColor(R.color.design_default_color_on_primary))
                .secondaryColor(context.getResources().getColor(R.color.design_default_color_on_secondary))
                .position(SlidrPosition.HORIZONTAL)//|RIGHT|TOP|BOTTOM|VERTICAL|HORIZONTAL)
                .sensitivity(1f)
                .scrimColor(Color.BLACK)
                .scrimStartAlpha(0.8f)
                .scrimEndAlpha(0f)
                .velocityThreshold(2400)
                .distanceThreshold(0.25f)
                .edge(true|false)
                .edgeSize(0.18f) // The % of the screen that counts as the edge, default 18%
                .listener(new SlidrListener(){
                    @Override
                    public void onSlideStateChanged(int state) {
                        Log.e( "onSlideStateChanged: ", String.valueOf(state));
                    }

                    @Override
                    public void onSlideChange(float percent) {
                        Log.e("onSlideChange: ", String.valueOf(percent));
                    }

                    @Override
                    public void onSlideOpened() {
                        Log.e("onSlideChange: ", "slid opned");
                    }

                    @Override
                    public boolean onSlideClosed() {
                         next_page(getApplicationContext());
                        return false;
                    }
                })
                .build();
        SlidrInterface slider = Slidr.attach((Activity) context, config2);

    }
   // go the same activity with intent
    private void next_page(Context context) {
        startActivity(new Intent(this, videoplayer_activity.class));
        finish();
    }

    public void setVideoData(Videomodel video) {
        Log.e( "setVideoData: ", video.getVideourl());
        videoView.setVideoPath("https://younesjarhbou.github.io/fakecall/momo_scary/video2.mp4");
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                startActivity(new Intent(videoplayer_activity.this, videoplayer_activity.class));
                finish();
            }
        });
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
                    @Override
                    public void onBufferingUpdate(MediaPlayer mp, int percent) {
                        Log.e( "onBufferingUpdate: ", String.valueOf(percent));
                        if (percent > 60 || disabledialog){
                            d.setCancelable(true);
                            d.dismiss();
                        }
                    }
                });
            }
        });

//        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mediaPlayer) {
//                mediaPlayer.start();
//            }
//        });

    }
}
