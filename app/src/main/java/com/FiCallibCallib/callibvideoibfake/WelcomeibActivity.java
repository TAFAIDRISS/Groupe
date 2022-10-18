package com.FiCallibCallib.callibvideoibfake;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.FiCallibCallib.callibvideoibfake.Ads_admob.Admob;

public class WelcomeibActivity extends AppCompatActivity {

    Button btn_nextActivity;
    Admob admob ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomeib);


        admob = new Admob(this);
        admob.LoadInters();

        btn_nextActivity = findViewById(R.id.btn_getstart);








        btn_nextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               /* Intent intent = new Intent(WelcomeibActivity.this,GenderActivity.class);
                startActivity(intent);
                finish();

                */

                admob.ShowInters(new Admob.AdFinishee() {
                    @Override
                    public void OnAdFinishid() {

                        Intent intent = new Intent(WelcomeibActivity.this,GenderActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });


                
            }
        });


    }


}


