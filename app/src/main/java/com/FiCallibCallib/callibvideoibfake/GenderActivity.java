package com.FiCallibCallib.callibvideoibfake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.service.autofill.OnClickAction;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import com.FiCallibCallib.callibvideoibfake.Ads_admob.Admob;
import com.FiCallibCallib.callibvideoibfake.CallGirle.MainActivity_callgirle;
import com.FiCallibCallib.callibvideoibfake.CallMain.MainActivity_callmain;

public class GenderActivity extends AppCompatActivity {

    //Chekbox select one Category
    CheckBox checkBox_One;
    CheckBox checkBox_too;
    Button next_Page;

    //MediaPlayer
    MediaPlayer mediaPlayer;
    //admob ads
    Admob admob;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gender_activity);
        //Admob Ads
        admob = new Admob(this);
        admob.LoadInters();
        admob.ShowBanner((LinearLayout) findViewById(R.id.lt_banner));

        //Views
        checkBox_One = findViewById(R.id.checkBox2);
        checkBox_too = findViewById(R.id.checkBox3);
        next_Page = findViewById(R.id.btn_next);

        //next Activity if else check box
        next_Page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (checkBox_One.isChecked() && !checkBox_too.isChecked()) {
                    getActivityGirle();

                } else if (checkBox_too.isChecked() && !checkBox_One.isChecked()) {
                    getActivityMain();
                } else if (checkBox_One.isChecked() == checkBox_too.isChecked()) {

                    Toast.makeText(GenderActivity.this, "Please Select One Category", Toast.LENGTH_SHORT).show();

                }
            }

        });

    }


//intent activity main
    void getActivityMain(){
        Intent ib = new Intent(getApplicationContext(), MainActivity_callmain.class);
        startActivity(ib);
        finish();

    }
//intent activity girl
    void getActivityGirle(){
        admob.ShowInters(new Admob.AdFinishee() {
            @Override
            public void OnAdFinishid() {

                Intent ib = new Intent(getApplicationContext(), MainActivity_callgirle.class);
                startActivity(ib);
                finish();
            }
        });

    }
}