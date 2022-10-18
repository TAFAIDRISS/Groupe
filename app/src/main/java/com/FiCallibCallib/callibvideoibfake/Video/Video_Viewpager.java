package com.FiCallibCallib.callibvideoibfake.Video;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import com.FiCallibCallib.callibvideoibfake.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Video_Viewpager extends AppCompatActivity {


    ArrayList<Videomodel>videomodels;
    ViewPager2 viewPager2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_viewpager);

        videomodels = new ArrayList<>();
        viewPager2 = findViewById(R.id.viewpagerr);


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

        Collections.shuffle(videomodels);

        AdapterViedo adapter =new AdapterViedo(videomodels,this);
        viewPager2.setAdapter(adapter);



    }



}
