package com.FiCallibCallib.callibvideoibfake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.FiCallibCallib.callibvideoibfake.GetData.GetData;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class Spalsh_Activity extends AppCompatActivity {

    ProgressBar progressBar ;
    TextView tx ;
    Timer time =new Timer();
    int countr = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh);

        GetData.ConncetDataURL(this);

        progressBar = findViewById(R.id.pb_splash);
        tx = findViewById(R.id.txt_splash);

        final long period = 20 ;

        time.schedule(new TimerTask() {
            @Override
            public void run() {
                if (countr < 100){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tx.setText(countr+ "%");
                        }
                    });
        progressBar.setProgress(countr);
        countr++ ;

                }else {
                    time.cancel();

                    Intent inten =new Intent(getApplicationContext(),WelcomeibActivity.class);
                    startActivity(inten);

                    finish();


                }
            }
        },0, period);





    }
}