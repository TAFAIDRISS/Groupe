package com.FiCallibCallib.callibvideoibfake;

import android.Manifest;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.StrictMode;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.hsalf.smilerating.SmileRating;
import com.r0adkll.slidr.model.SlidrInterface;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class function {

    public static void flliperimage(Integer image, Context context, ViewFlipper viewFlipper)  {
        ImageView imageView = new ImageView(context);
        //   imageView.setBackgroundResource(image);
        // Picasso.get().load(image).into(imageView);


// Hide progress bar on successful load
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//        Ion.with(imageView)
//                .placeholder(R.drawable.loading1)
//                .load(image);
       // Picasso.get().load(R.id.accept).placeholder(R.drawable.loading1).into(imageView);
           imageView.setImageResource(image);
        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(1000);
        viewFlipper.setAutoStart(true);

        ///animation you can edit it ass you want
        viewFlipper.setInAnimation(context, android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(context, android.R.anim.slide_out_right);




    }
//    public static void rat_dialog(Context context ,Dialog d) {
//
//
//        d.setContentView(R.layout.rate_dialog);
//
//      ImageView  ratoremail = d.findViewById(R.id.rate_us);
//      //  ratoremail.setEnabled(false);
//        ratoremail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                rateApp(context);
//                d.dismiss();
//            }
//        });
//        // win_img=d.findViewById(R.id.win_image);
//        //  Drawable new_image= getResources().getDrawable(R.drawable.androidcanary);
//        //  win_img.setBackgroundDrawable(new_image);
//        d.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        SmileRating smileRating = (SmileRating) d.findViewById(R.id.smile_rating);
//        Window win = d.getWindow();
//        win.setGravity(Gravity.CENTER);
//        smileRating.setOnSmileySelectionListener(new SmileRating.OnSmileySelectionListener() {
//            @Override
//            public void onSmileySelected(@BaseRating.Smiley int smiley, boolean reselected) {
//                // reselected is false when user selects different smiley that previously selected one
//                // true when the same smiley is selected.
//                // Except if it first time, then the value will be false.
//
//                switch (smiley) {
//                    case SmileRating.BAD:
//                        //    Log.i(TAG, "Bad");
//
//
//                        //Toast.makeText(MainActivity.this, "Bad", //Toast.LENGTH_SHORT).show();
//                        break;
//                    case SmileRating.GOOD:
//                        //  Log.i(TAG, "Good");
//
//                        //Toast.makeText(MainActivity.this, "Good", //Toast.LENGTH_SHORT).show();
//                        break;
//                    case SmileRating.GREAT:
//                        //   Log.i(TAG, "Great");
//
//                        break;
//                    case SmileRating.OKAY:
//                        //   Log.i(TAG, "Okay");
//
//                        //Toast.makeText(MainActivity.this, "Okay", //Toast.LENGTH_SHORT).show();
//                        break;
//                    case SmileRating.TERRIBLE:
//
//                        //Toast.makeText(MainActivity.this, "Terrible", //Toast.LENGTH_SHORT).show();
//                        break;
//                }
//            }
//        });
//        win.getAttributes().windowAnimations = R.style.mydialog;
//
//     /*   ((ViewGroup)d.getWindow().getDecorView())
//                .getChildAt(0).startAnimation(AnimationUtils.loadAnimation(
//                this,R.anim.bialogue_anim));   */
//
//        //
//        d.show();
//
//
//
//
//    }
    public static void composeEmail(String[] addresses, String subject,Context  context) {
        //   showOrIncreaseCounter();
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }
    public static void rateApp(Context context) {


        Uri uri = Uri.parse("market://details?id=" + context.getPackageName());
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        // To count with Play market backstack, After pressing back button,
        // to taken back to our application, we need to add following flags to intent.
        goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        goToMarket.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try {
            context.startActivity(goToMarket);
        } catch (ActivityNotFoundException e) {
            context.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=" + context.getPackageName())).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        }
    }

    public static void loading(Context context,Dialog d) {


        d.setContentView(R.layout.loading);
        LottieAnimationView loti = d.findViewById(R.id.loti_minimal_loading);
        loti.setAnimationFromUrl(config.loti_minimal_loading);
        LottieAnimationView loti2 = d.findViewById(R.id.loti_big_view);
        loti2.setAnimationFromUrl(config.loti_big_loading);

        loti.addAnimatorListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                Log.e( "onAnimationEnd: ","end" );
                super.onAnimationEnd(animation);
            }

            @Override
            public void onAnimationStart(Animator animation) {
                Log.e( "onAnimationStart: ","fds" );
                super.onAnimationStart(animation);
            }

            @Override
            public void onAnimationStart(Animator animation, boolean isReverse) {
                Log.e( "onAnimationStart: ", "fdsfds");

            }

            @Override
            public void onAnimationEnd(Animator animation, boolean isReverse) {
                Log.e( "onAnimationEnd: ", "dsfdsf");

            }
        });
           //  ImageView imageView= d.findViewById(R.id.loadinggif);
     //   Picasso.get().load(R.drawable.background_gif).placeholder(R.drawable.background_gif).into(imageView);
       // Glide.with(context).load(R.drawable.background_gif).into(imageView);
        // win_img=d.findViewById(R.id.win_image);
        //  Drawable new_image= getResources().getDrawable(R.drawable.androidcanary);
        //  win_img.setBackgroundDrawable(new_image);
        d.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        d.setCancelable(false);
        Window win = d.getWindow();
        win.setGravity(Gravity.CENTER);

        win.getAttributes().windowAnimations = R.style.mydialog;

     /*   ((ViewGroup)d.getWindow().getDecorView())
                .getChildAt(0).startAnimation(AnimationUtils.loadAnimation(
                this,R.anim.bialogue_anim));   */

        //
        d.show();

    }

//    public static void rating_animation(Dialog d,int i) {
//        SmileRating smileRating = (SmileRating) d.findViewById(R.id.smile_rating);
////      if (i==-1){
////          smileRating.setSelectedSmile(BaseRating.NONE);
////      }
//
//
//
//       smileRating.setSelectedSmile(i);
//
//    }
    public static  void shareit(Context context){

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "download our amazing app :\n"+"https://play.google.com/store/apps/details?id="+context.getPackageName());
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        shareIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(shareIntent);
    }
    public static void openlink(Context context,String link) {


        context.startActivity(new Intent(Intent.ACTION_VIEW,
                Uri.parse(link)).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

//    @SuppressLint("SetJavaScriptEnabled")
//    public static void cpa_dialog(Context context) {
//
//        final    Dialog d = new Dialog(context, R.style.mydialog);
//        d.setContentView(R.layout.contentlocker);
//
//        final WebView webView2 = d.findViewById(R.id.contentlocker);
//
//        webView2.clearCache(true);
//        webView2.clearHistory();
//        webView2.getSettings().setJavaScriptEnabled(true);
//        webView2.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
//
//        // win_img=d.findViewById(R.id.win_image);
//        //  Drawable new_image= getResources().getDrawable(R.drawable.androidcanary);
//        //  win_img.setBackgroundDrawable(new_image);
//        d.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//
//        Window win = d.getWindow();
//        win.setGravity(Gravity.CENTER);
//
//        win.getAttributes().windowAnimations = R.style.mydialog;
//
//     /*   ((ViewGroup)d.getWindow().getDecorView())
//                .getChildAt(0).startAnimation(AnimationUtils.loadAnimation(
//                this,R.anim.bialogue_anim));   */
//
//        //
//        // sharedpreferences = getSharedPreferences("wiyha", Context.MODE_PRIVATE);
//        SharedPreferences sharedpreferences;
//        long s1 = Long.parseLong(get_shared(context,"time","locker_done"));
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault());
//        String currentDateandTime = sdf.format(new Date());
//        long s2 = Long.parseLong(currentDateandTime);
//        Log.e("deftime", String.valueOf(s2-s1));
//        if (s2-s1>config.locker_delay_in_second) {
//            d.show();
//
//            webView2.loadUrl(config.cpalink);
//            webView2.setWebViewClient(new WebViewClient() {
//                @Override
//                public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                    //    currentUrl = url;
//
//                    if (url.startsWith("http") || url.startsWith("https")) {
//                        return false;
//                    }
//                    if (url.startsWith("intent")) {
//
//
//                        try {
//                            Intent intent = Intent.parseUri(url, Intent.URI_INTENT_SCHEME);
//
//                            String fallbackUrl = intent.getStringExtra("browser_fallback_url");
//                            if (fallbackUrl != null) {
//                                webView2.loadUrl(fallbackUrl);
//                                return true;
//                            }
//                        } catch (URISyntaxException e) {
//                            //not an intent uri
//                        }
//                        return true;//do nothing in other cases
//                    }else{
//                        function.openlink(context,url);
//                        return true;
//                    }
//
//                }
//                @Override
//                public void onPageFinished(WebView view, String url) {
//                    super.onPageFinished(view, url);
//                    // progressBar.setVisibility(View.GONE);
//                    // WebviewLoaded = true;
//                    //  view.loadUrl("javascript:window.android.onUrlChange(window.location.href);");
//                    //  webView.loadUrl("javascript:(function() { var el = document.querySelectorAll('div[data-sigil]');for(var i=0;i<el.length; i++){var sigil = el[i].dataset.sigil;if(sigil.indexOf('inlineVideo') > -1){delete el[i].dataset.sigil;var jsonData = JSON.parse(el[i].dataset.store);el[i].setAttribute('onClick', 'FBDownloader.processVideo(\"'+jsonData['src']+'\");');}}})()");
//                    Log.e("WEBVIEWFIN", url);
//
//                    if (url.contains("offerdone")) {
//                        //Toast.makeText(activity, "offer done", Toast.LENGTH_SHORT).show();
//                        //   GeneratingDownloadLinks.Start(MainActivity.this, webView.getUrl(), webView.getTitle());
//                        d.dismiss();
//                        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault());
//                        String currentDateandTime = sdf.format(new Date());
//                        //       SharedPreferences sharedpreferences = getSharedPreferences("wiyha", Context.MODE_PRIVATE);
//                        put_shared(context,"time",currentDateandTime,"locker_done");
////                        SharedPreferences.Editor editor = sharedpreferences.edit();
////                        editor.putLong("locker_done", Long.parseLong(currentDateandTime));
////                        editor.apply();
//                        //    Log.e("time", String.valueOf(currentDateandTime));
//
//                    }
//
//
//                }
//
//            });
//        }else{
//            //     GeneratingDownloadLinks.Start(MainActivity.this, webView.getUrl(), webView.getTitle());
//
//        }
//    }



    public static  void  opendeveloperpage(Context context){

        Uri uri = Uri.parse("https://play.google.com/store/apps/developer?id=" + config.developer);
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        // To count with Play market backstack, After pressing back button,
        // to taken back to our application, we need to add following flags to intent.
        goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        goToMarket.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try {
            context.startActivity(goToMarket);
        } catch (ActivityNotFoundException e) {
            context.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/developer?id=" + config.developer)));
        }
    }

    public  static void loadpicture(Context context,ImageView imageView,String link){

      //  Picasso.get().load(link).placeholder(R.drawable.loading1).into(imageView);
        Glide.with(context).load(link).placeholder(R.drawable.loading1).into(imageView);
    }

    public static void setImagebackground(View view, String url) {
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            URL x2 = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) x2.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            Drawable dr = new BitmapDrawable(myBitmap);
            view.setBackgroundDrawable(dr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    public static void locked_dialog(Context context ) {
//        if (config.activatelocker.equals("1")) {
//            Dialog d = new Dialog(context, R.style.mydialog);
//            d.setCancelable(true);
//            d.setContentView(R.layout.locked_ui);
//            LinearLayout bg = d.findViewById(R.id.lockedbg);
//            setImagebackground(bg,config.lockedbg);
//
//            if (!config.step1.equals("0")) {
//                ImageView firststep1 = d.findViewById(R.id.step1);
//                firststep1.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        locked_step1(context);
//
//
//                    }
//                });
//                loadpicture(context, firststep1, config.step1);
//            } else {
//                ImageView firststep1 = d.findViewById(R.id.step1);
//                firststep1.setVisibility(View.INVISIBLE);
//            }
//            if (!config.step2.equals("0")) {
//                ImageView firststep2 = d.findViewById(R.id.step2);
//                firststep2.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        locked_step2(context);
//
//
//                    }
//                });
//                loadpicture(context, firststep2, config.step2);
//            } else {
//                ImageView firststep2 = d.findViewById(R.id.step2);
//                firststep2.setVisibility(View.INVISIBLE);
//            }
//            if (!config.step3.equals("0")) {
//                ImageView firststep3 = d.findViewById(R.id.step3);
//                firststep3.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        locked_step3(context);
//
//
//                    }
//                });
//                loadpicture(context, firststep3, config.step3);
//            } else {
//                ImageView firststep3 = d.findViewById(R.id.step3);
//                firststep3.setVisibility(View.INVISIBLE);
//            }
//
//            ImageView lockedlogo = d.findViewById(R.id.locked_logo);
//            ImageView nothanks = d.findViewById(R.id.NO_THANKS);
//            TextView lockedtxt = d.findViewById(R.id.lockedtxt);
//
//
//            loadpicture(context, lockedlogo, config.lockedlogo);
//            lockedtxt.setText(config.lockedtxt);
//            loadpicture(context, nothanks, config.nothanks);
//            nothanks.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
////            long s1 = Long.parseLong(get_shared(context,"time","locker_done"));
////            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault());
////            String currentDateandTime = sdf.format(new Date());
////            long s2 = Long.parseLong(currentDateandTime);
////            Log.e("deftime", String.valueOf(s2-s1));
////            if (s1==0){
////                Toast.makeText(context.getApplicationContext(), "Please Complete the Task Firstly", Toast.LENGTH_LONG).show();
////            }
////            if (s2-s1>config.locker_delay_in_second){
////                Log.e( "onClick: ","if" );
////                Toast.makeText(context.getApplicationContext(), "Please Complete the Task Firstly", Toast.LENGTH_LONG).show();
////            }else {
////                Log.e( "onClick: ","else" );
////                d.dismiss();
////            }
//                    long s1 = Long.parseLong(get_shared(context,"time","locker_done"));
//                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault());
//                    String currentDateandTime = sdf.format(new Date());
//                    long s2 = Long.parseLong(currentDateandTime);
//                    Log.e("deftime", String.valueOf(s2-s1));
//                    if (s1==0){
//                        Toast.makeText(context.getApplicationContext(), "Please Complete the Task Firstly", Toast.LENGTH_LONG).show();
//                    }
//                    if (s2-s1>config.locker_delay_in_second){
//                        Log.e( "onClick: ","if" );
//                        Toast.makeText(context.getApplicationContext(), "Please Complete the Task Firstly", Toast.LENGTH_LONG).show();
//                    }else {
//                        Log.e( "onClick: ","else" );
//                        d.dismiss();
//                    }
//
//
//
//                }
//            });
//
////    firststep2.setOnClickListener(new View.OnClickListener() {
////        @Override
////        public void onClick(View v) {
////            rateApp(context);
////            function.put_shared(context,"step2","done","locked");
////        }
////    });
////    if (! function.get_shared(context,"step2","locked").equals("0")){
////
////     //   firststep2.setVisibility(View.INVISIBLE);
////    }
//
////    if (! function.get_shared(context,"step1","locked").equals("0")){
////
////        firststep1.setVisibility(View.INVISIBLE);
////    }
//            //  ratoremail.setEnabled(false);
//
//            // win_img=d.findViewById(R.id.win_image);
//            //  Drawable new_image= getResources().getDrawable(R.drawable.androidcanary);
//            //  win_img.setBackgroundDrawable(new_image);
//            d.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//
//            Window win = d.getWindow();
//            win.setGravity(Gravity.CENTER);
//
//            win.getAttributes().windowAnimations = R.style.mydialog;
//
//     /*   ((ViewGroup)d.getWindow().getDecorView())
//                .getChildAt(0).startAnimation(AnimationUtils.loadAnimation(
//                this,R.anim.bialogue_anim));   */
//
//            //
//            d.show();
//
//        }
//
//
//    }
//
//    private static void locked_step1(Context context) {
//        if (config.step1type.equals("cpa")){
//            cpa_dialog(context);
//        }
//        else if (config.step1type.equals("apploving")){
//            my_own_ads_2021.apploving_reward();
//        }
//        else if (config.step1type.equals("admob")){
//            my_own_ads_2021.admob_reward(context);
//        }
//        else if (config.step1type.equals("unity")){
//            my_own_ads_2021.reward_unity(context);
//        }
//        else if (config.step1type.equals("fb")){
//            my_own_ads_2021.fb_reward(context);
//        }
//        else if (config.step1type.equals("tapdaq")){
//            my_own_ads_2021.tapdaq_reward(context);
//        }
//        else if (config.step1type.equals("ironsrc")){
//            my_own_ads_2021.ironsrc_reward(context);
//        }
//
//        else if (config.step1type.equals("offerwall")){
//            my_own_ads_2021.offerwall_ironsrc(context);
//        }
//        else if (config.step1type.equals("share")){
//            shareit(context);
//        }
//        else {
//            openlink(context,config.step1type);
//        }
//
//    }
//    private static void locked_step2(Context context) {
//        if (config.step2type.equals("cpa")){
//            cpa_dialog(context);
//        }
//        else if (config.step2type.equals("apploving")){
//            my_own_ads_2021.apploving_reward();
//        }
//        else if (config.step2type.equals("admob")){
//            my_own_ads_2021.admob_reward(context);
//        }
//        else if (config.step2type.equals("unity")){
//            my_own_ads_2021.reward_unity(context);
//        }
//        else if (config.step2type.equals("fb")){
//            my_own_ads_2021.fb_reward(context);
//        }
//        else if (config.step2type.equals("tapdaq")){
//            my_own_ads_2021.tapdaq_reward(context);
//        }
//        else if (config.step1type.equals("ironsrc")){
//            my_own_ads_2021.ironsrc_reward(context);
//        }
//        else if (config.step1type.equals("offerwall")){
//            my_own_ads_2021.offerwall_ironsrc(context);
//        }
//        else if (config.step2type.equals("share")){
//            shareit(context);
//        }
//        else {
//            openlink(context,config.step2type);
//        }
//    }
//    private static void locked_step3(Context context) {
//        if (config.step3type.equals("cpa")){
//            cpa_dialog(context);
//        }
//        else if (config.step3type.equals("apploving")){
//            my_own_ads_2021.apploving_reward();
//        }
//        else if (config.step3type.equals("admob")){
//            my_own_ads_2021.admob_reward(context);
//        }
//        else if (config.step3type.equals("unity")){
//            my_own_ads_2021.reward_unity(context);
//        }
//        else if (config.step3type.equals("fb")){
//            my_own_ads_2021.fb_reward(context);
//        }
//        else if (config.step3type.equals("tapdaq")){
//            my_own_ads_2021.tapdaq_reward(context);
//        }
//        else if (config.step1type.equals("ironsrc")){
//            my_own_ads_2021.ironsrc_reward(context);
//        }
//        else if (config.step1type.equals("offerwall")){
//            my_own_ads_2021.offerwall_ironsrc(context);
//        }
//        else if (config.step3type.equals("share")){
//            shareit(context);
//        }
//        else {
//            openlink(context,config.step3type);
//        }
//    }

    public static void put_shared(Context context,String key,String value,String sharedname){


            SharedPreferences sharedpreferences = context.getSharedPreferences(sharedname, Context.MODE_PRIVATE);


            SharedPreferences.Editor editor2 = sharedpreferences.edit();
            editor2.putString(key, value);
            editor2.apply();
         //   Log.e("shared_wiyha","if");
//        }else {
//
//            Log.e("shared_wiyha","else"+ config.you);
//
//        }

    }

    public  static String get_shared(Context context,String key,String sharedname){

        SharedPreferences sharedpreferences = context.getSharedPreferences(sharedname, Context.MODE_PRIVATE);
        String s = sharedpreferences.getString(key,"null");
//        if (config.shared_you.contains("null")){
//            //  Toast.makeText(activity, "youtube is not supported due to youtube policy", Toast.LENGTH_SHORT).show();
//
//            return "null";
//        }
//        else{
//            return  true;
//        }
return  s;
    }


    public  static void creatnotificationChannel(Context context)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            CharSequence name = " some default name";
            String description ="Channel for some default name";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("myidjarhbou", name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

//    public  static void delaynotify(Context context)
//    {
//        creatnotificationChannel(context);
//     //   Toast.makeText(context, "reminder set", Toast.LENGTH_SHORT).show();
//        Log.e( "delaynotify: ","reminder set" );
//        Intent intent = new Intent(context, notificationmanager.class);
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
//        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
//        long timeAtactioncall = System.currentTimeMillis();
//        long delaytime =  1000*10;
//        alarmManager.set(AlarmManager.RTC_WAKEUP,
//                timeAtactioncall+delaytime,
//                pendingIntent);
//    }




    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static void startJob(Context context){
//        //    Toast.makeText(context, "job set2", Toast.LENGTH_SHORT).show();
//        permission_dialog_extra_security(context);
//        JobInfo jobInfo;
//        long flexMillis = 10 * 1000; // wait 59 minutess before executing next job
//        @SuppressLint("JobSchedulerService")  ComponentName componentName = new ComponentName(context, notificationjobIntentService.class);
//        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.N) {
//
//
//            jobInfo = new JobInfo.Builder(101, componentName)
//                    .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
//                    .setPeriodic(flexMillis)
//                    .setPersisted(true)
//                    .build();
//        }
//        else {
//
//
//            jobInfo = new JobInfo.Builder(101, componentName)
//                    .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
//                    .setMinimumLatency(flexMillis)
//                    .setPersisted(true)
//                    .build();
//        }
//        JobScheduler jobScheduler = (JobScheduler)context.getSystemService(Context.JOB_SCHEDULER_SERVICE);
//        jobScheduler.schedule(jobInfo);
//        if(jobScheduler.schedule(jobInfo)==JobScheduler.RESULT_SUCCESS){
//            Log.e("startJob", "MainActivity thread id: " + Thread.currentThread().getId()+", job successfully scheduled");
//        }else {
//            Log.e("startJob", "MainActivity thread id: " + Thread.currentThread().getId()+", job could not be scheduled");
//        }
    }

    public static void extrasecurity_service(Context context)
    {
        try {
            Intent[] POWERMANAGER_INTENTS = {
                    new Intent().setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity")),
                    new Intent().setComponent(new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.AutobootManageActivity")),
                    new Intent().setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity")),
                    new Intent().setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity")),
                    new Intent().setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.appcontrol.activity.StartupAppControlActivity")),
                    new Intent().setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.permission.startup.StartupAppListActivity")),
                    new Intent().setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.startupapp.StartupAppListActivity")),
                    new Intent().setComponent(new ComponentName("com.oppo.safe", "com.oppo.safe.permission.startup.StartupAppListActivity")),
                    new Intent().setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.AddWhiteListActivity")),
                    new Intent().setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.BgStartUpManager")),
                    new Intent().setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.BgStartUpManagerActivity")),
                    new Intent().setComponent(new ComponentName("com.samsung.android.lool", "com.samsung.android.sm.battery.ui.BatteryActivity")),
                    new Intent().setComponent(new ComponentName("com.samsung.android.lool", "com.samsung.android.sm.ui.battery.BatteryActivity")),
                    new Intent().setComponent(new ComponentName("com.htc.pitroad", "com.htc.pitroad.landingpage.activity.LandingPageActivity")),
                    new Intent().setComponent(new ComponentName("com.asus.mobilemanager", "com.asus.mobilemanager.MainActivity")),
                    new Intent().setComponent(new ComponentName("com.transsion.phonemanager", "com.itel.autobootmanager.activity.AutoBootMgrActivity"))
            };

            for (Intent intent : POWERMANAGER_INTENTS) {
                @SuppressLint("QueryPermissionsNeeded") List<ResolveInfo> list = context.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
                //  Log.e( "extrasecurity_service: ", list.get(0).resolvePackageName);
//                if (list.size() > 0) {
//                    Log.e( "extrasecurity_service: ",list.get(0).);
//                    context.startActivity(intent);
//                }
                if (context.getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY) != null) {
                    // show dialog to ask user action
                    if (context.getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY) != null) {
                        //  intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                        break;
                    }
                }
            }

        }
        catch(Exception E)
        {
            Log.e( "extrasecurity_service: ",E.getMessage() );
        }

    }

//    public static void restartservice_withbroad(Context context) {
//        AlarmManager alarmMgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
//        Intent intent = new Intent(context, restrartservice.class);
//        PendingIntent alarmIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
//        alarmMgr.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
//                SystemClock.elapsedRealtime() +
//                        10000, alarmIntent);
//    }
//    public static void incomingservice_withbroad(Context context) {
//        AlarmManager alarmMgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
//        Intent intent = new Intent(context, incomingcallbroadcast.class);
//        intent.setAction(Intent.ACTION_NEW_OUTGOING_CALL);
//        PendingIntent alarmIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
//        alarmMgr.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
//
//                        1000, alarmIntent);
//    }
//    public static String getrandomof_array(ArrayList<String> videoarray) {
//        int index = (int)(Math.random() * videoarray.size());
//
//        Log.e( "getrandomof_array: ", String.valueOf(index));
//               return (videoarray.get(index));
//    }
//
//    public  static  void incomingbackgroundcalls(Context context, own_calbackground type)
//    {   if (type.getType().equals("notif"))
//        {
//            config.owncall_currentone = type;
//            delaynotify(context);
//        }
//        else {
//        Intent in = new Intent(context.getApplicationContext(), Incomingcalls.class);
//        in.putExtra("type", type.getType());
//        in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(in);
//      //  ((Activity)context).finish();
//        }
//    }
//    public  static own_calbackground checkowncakk_ability(String time){
//        int i =0;
//        for (i = 0 ; i < config.callarray.size() ; i++)
//        {
//            if (config.callarray.get(i).getTime().equals(time))
//                return (config.callarray.get(i));
//
//        }
//        return (null);
//    }

    public static void permission_dialog(Context context, int requestCode) {

        Dialog d = new Dialog(context, R.style.mydialog);
        d.setContentView(R.layout.permission_dialog);

        Button ratoremail = d.findViewById(R.id.btn_go_to_permission);
        //  ratoremail.setEnabled(false);
        ratoremail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.dismiss();
                ActivityCompat.requestPermissions((Activity) context, REQUESTED_PERMISSIONS, requestCode);

            }
        });
        // win_img=d.findViewById(R.id.win_image);
        //  Drawable new_image= getResources().getDrawable(R.drawable.androidcanary);
        //  win_img.setBackgroundDrawable(new_image);
        d.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Window win = d.getWindow();
        win.setGravity(Gravity.CENTER);

      //  win.getAttributes().windowAnimations = R.style.mydialog;

     /*   ((ViewGroup)d.getWindow().getDecorView())
                .getChildAt(0).startAnimation(AnimationUtils.loadAnimation(
                this,R.anim.bialogue_anim));   */

        //
        d.show();


    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    public static void permission_dialog_candraw(Context context) {

        if (!Settings.canDrawOverlays(context))
        {
            Dialog d = new Dialog(context, R.style.mydialog);
            d.setContentView(R.layout.permission_dialog_candraw);

            Button ratoremail = d.findViewById(R.id.btn_go_to_permission);

            //  ratoremail.setEnabled(false);
            ratoremail.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.M)
                @Override
                public void onClick(View v) {

                    if (!Settings.canDrawOverlays(context))
                    {
                        ((Activity)context).startActivityForResult(new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION),20);
                    }
                    d.dismiss();
                }
            });
            // win_img=d.findViewById(R.id.win_image);
            //  Drawable new_image= getResources().getDrawable(R.drawable.androidcanary);
            //  win_img.setBackgroundDrawable(new_image);
            d.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            Window win = d.getWindow();
            win.setGravity(Gravity.CENTER);

            //  win.getAttributes().windowAnimations = R.style.mydialog;

     /*   ((ViewGroup)d.getWindow().getDecorView())
                .getChildAt(0).startAnimation(AnimationUtils.loadAnimation(
                this,R.anim.bialogue_anim));   */

            //
            d.show();

        }



    }
    public static void permission_dialog_extra_security(Context context) {
        Intent[] POWERMANAGER_INTENTS = {
                new Intent().setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity")),
                new Intent().setComponent(new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.AutobootManageActivity")),
                new Intent().setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity")),
                new Intent().setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity")),
                new Intent().setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.appcontrol.activity.StartupAppControlActivity")),
                new Intent().setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.permission.startup.StartupAppListActivity")),
                new Intent().setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.startupapp.StartupAppListActivity")),
                new Intent().setComponent(new ComponentName("com.oppo.safe", "com.oppo.safe.permission.startup.StartupAppListActivity")),
                new Intent().setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.AddWhiteListActivity")),
                new Intent().setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.BgStartUpManager")),
                new Intent().setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.BgStartUpManagerActivity")),
                new Intent().setComponent(new ComponentName("com.samsung.android.lool", "com.samsung.android.sm.battery.ui.BatteryActivity")),
                new Intent().setComponent(new ComponentName("com.samsung.android.lool", "com.samsung.android.sm.ui.battery.BatteryActivity")),
                new Intent().setComponent(new ComponentName("com.htc.pitroad", "com.htc.pitroad.landingpage.activity.LandingPageActivity")),
                new Intent().setComponent(new ComponentName("com.asus.mobilemanager", "com.asus.mobilemanager.MainActivity")),
                new Intent().setComponent(new ComponentName("com.transsion.phonemanager", "com.itel.autobootmanager.activity.AutoBootMgrActivity"))
        };

        for (Intent intent : POWERMANAGER_INTENTS) {
            @SuppressLint("QueryPermissionsNeeded") List<ResolveInfo> list = context.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
            //  Log.e( "extrasecurity_service: ", list.get(0).resolvePackageName);
//                if (list.size() > 0) {
//                    Log.e( "extrasecurity_service: ",list.get(0).);
//                    context.startActivity(intent);
//                }
            if (context.getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY) != null) {
                // show dialog to ask user action
                if (get_shared(context, "extrasecurity","extrasecurity") == "null"){

                    Dialog d = new Dialog(context, R.style.mydialog);
                    d.setContentView(R.layout.permission_dialog_extrasecurity);

                    Button ratoremail = d.findViewById(R.id.btn_go_to_permission);
                    CheckBox dontshowagain = d.findViewById(R.id.dontshowagain);
                    //  ratoremail.setEnabled(false);
                    ratoremail.setOnClickListener(new View.OnClickListener() {
                        @RequiresApi(api = Build.VERSION_CODES.M)
                        @Override
                        public void onClick(View v) {
                            if (dontshowagain.isChecked())
                                put_shared(context, "extrasecurity", "extrasecurity", "extrasecurity");
                            function.extrasecurity_service(context);
                            d.dismiss();
                        }
                    });
                    dontshowagain.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Toast.makeText(context, "attention we need this permission to work perfectly", Toast.LENGTH_LONG).show();

                        }
                    });
                    // win_img=d.findViewById(R.id.win_image);
                    //  Drawable new_image= getResources().getDrawable(R.drawable.androidcanary);
                    //  win_img.setBackgroundDrawable(new_image);
                    d.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    Window win = d.getWindow();
                    win.setGravity(Gravity.CENTER);

                    //  win.getAttributes().windowAnimations = R.style.mydialog;

     /*   ((ViewGroup)d.getWindow().getDecorView())
                .getChildAt(0).startAnimation(AnimationUtils.loadAnimation(
                this,R.anim.bialogue_anim));   */

                    //
                    try {
                        d.show();
                    }catch (Exception E) {
                        Log.e( "extra_security: ", E.getMessage());
                    }


                }
            }
        }



    }
    public static final int PERMISSION_REQ_ID = 22;

    // Ask for Android device permissions at runtime.
    public static final String[] REQUESTED_PERMISSIONS = {
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE

    };
    public static boolean checkSelfPermission(Context context, String permission, int requestCode) {
        if (ContextCompat.checkSelfPermission(context, permission) !=
                PackageManager.PERMISSION_GRANTED) {
            permission_dialog(context, requestCode);

            return false;
        }


        return true;
    }

//    public static void slid_it(Context context) {
//
//        SlidrConfig config = new SlidrConfig.Builder()
//                .primaryColor(context.getColor(R.color.design_default_color_on_primary))
//                        .secondaryColor(context.get(R.color.design_default_color_on_secondary))
//                                .position(SlidrPosition.LEFT)//|RIGHT|TOP|BOTTOM|VERTICAL|HORIZONTAL)
//                                .sensitivity(1f)
//                                .scrimColor(Color.BLACK)
//                                .scrimStartAlpha(0.8f)
//                                .scrimEndAlpha(0f)
//                                .velocityThreshold(2400)
//                                .distanceThreshold(0.25f)
//                                .edge(true|false)
//                                .edgeSize(0.18f) // The % of the screen that counts as the edge, default 18%
//                                .listener(new SlidrListener(){...})
//                                .build();
//
//        Slidr.attach(this, config);
//    }

    public static  void lockSlide(SlidrInterface slidr) {
        slidr.lock();
    }

    public static void unlockSlide(SlidrInterface slidr) {
        slidr.unlock();
    }


    public static void skip_after5(Context context,LottieAnimationView loti,SlidrInterface slidr)
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
