package com.FiCallibCallib.callibvideoibfake.Ads_admob;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.FiCallibCallib.callibvideoibfake.CustomUtil_lesLien.Lien_URL;
import com.FiCallibCallib.callibvideoibfake.GetData.GetData;
import com.FiCallibCallib.callibvideoibfake.R;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.ads.nativead.NativeAdView;

public class Admob {

    AppCompatActivity activity ;
    private InterstitialAd mInterstitialAd;

    public interface AdFinishee{
        void OnAdFinishid();
    }

    public Admob(AppCompatActivity activity){
        this.activity=activity;
        MobileAds.initialize(activity);
    }

    public  void ShowBanner(LinearLayout layout){

        AdView adView = new AdView(activity);
        adView.setAdUnitId(GetData.BannerAdmob);
        adView.setAdSize(AdSize.BANNER);
        layout.addView(adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

    }
    public  void LoadInters(){
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(activity,GetData.IntersAdmob, adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        mInterstitialAd = null;
                    }
                });

    }

    public  void ShowInters(AdFinishee adFinishee){


        if (mInterstitialAd != null) {
            mInterstitialAd.show(activity);

            mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                @Override
                public void onAdClicked() {
                    // Called when a click is recorded for an ad.
                }

                @Override
                public void onAdDismissedFullScreenContent() {
                    // Called when ad is dismissed.
                    // Set the ad reference to null so you don't show the ad a second time.
                    adFinishee.OnAdFinishid();
                    mInterstitialAd = null;
                }

                @Override
                public void onAdFailedToShowFullScreenContent(AdError adError) {
                    // Called when ad fails to show.
                    adFinishee.OnAdFinishid();
                    mInterstitialAd = null;
                }

                @Override
                public void onAdImpression() {
                    // Called when an impression is recorded for an ad.
                }

                @Override
                public void onAdShowedFullScreenContent() {
                    // Called when ad is shown.
                    mInterstitialAd = null;
                    LoadInters();

                }
            });
        }else {
            adFinishee.OnAdFinishid();
        }

    }
    public  void ShowNative(RelativeLayout layout){

        AdLoader adLoader = new AdLoader.Builder(activity, Lien_URL.URL_JS)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        // Show the ad.
                        NativeAdView  nativeAdView =(NativeAdView) activity.getLayoutInflater()
                                .inflate(R.layout.item_native_adview,null);

                        ItemNative_Ads(nativeAd,nativeAdView);
                        layout.removeAllViews();
                        layout.addView(nativeAdView);

                    }
                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {
                        // Handle the failure by logging, altering the UI, and so on.
                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()
                        // Methods in the NativeAdOptions.Builder class can be
                        // used here to specify individual options settings.
                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());
    }
    public void ItemNative_Ads(com.google.android.gms.ads.nativead.NativeAd nativeAd, NativeAdView adView){


        adView.setMediaView((com.google.android.gms.ads.nativead.MediaView)adView.findViewById(R.id.ad_media));

        adView.setHeadlineView(adView.findViewById(R.id.ad_headline));
        adView.setBodyView(adView.findViewById(R.id.ad_body));
        adView.setCallToActionView(adView.findViewById(R.id.ad_call_action));
        adView.setIconView(adView.findViewById(R.id.ad_icon));
        adView.setPriceView(adView.findViewById(R.id.ad_price));
        adView.setStarRatingView(adView.findViewById(R.id.ad_start));
        adView.setStoreView(adView.findViewById(R.id.ad_store));
        adView.setAdvertiserView(adView.findViewById(R.id.ad_advertiser));

        ((TextView)adView.getHeadlineView()).setText(nativeAd.getHeadline());


        //TextView getBody
        if (nativeAd.getBody() == null){
            adView.getBodyView().setVisibility(View.INVISIBLE);
        }else {
            adView.getBodyView().setVisibility(View.VISIBLE);
            ((TextView)adView.getBodyView()).setText(nativeAd.getBody());
        }

        //Button Call Action
        if (nativeAd.getCallToAction() == null){
            adView.getCallToActionView().setVisibility(View.INVISIBLE);
        }else {
            adView.getCallToActionView().setVisibility(View.VISIBLE);
            ((Button)adView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }


        //get Icon Image Drawable
        if (nativeAd.getIcon() == null){
            adView.getIconView().setVisibility(View.INVISIBLE);
        }else {
            adView.getIconView().setVisibility(View.VISIBLE);
            ((ImageView)adView.getIconView()).setImageDrawable(nativeAd.getIcon().getDrawable());
        }


        //textview getPrice &
        if (nativeAd.getPrice() == null){
            adView.getPriceView().setVisibility(View.INVISIBLE);
        }else {
            adView.getPriceView().setVisibility(View.VISIBLE);
            ((TextView)adView.getPriceView()).setText(nativeAd.getPrice());
        }

        //textview get store
        if (nativeAd.getStore() == null){
            adView.getStoreView().setVisibility(View.INVISIBLE);
        }else {
            adView.getStoreView().setVisibility(View.VISIBLE);
            ((TextView)adView.getStoreView()).setText(nativeAd.getStore());
        }

        if (nativeAd.getStarRating() == null){
            adView.getStarRatingView().setVisibility(View.INVISIBLE);
        }else {
            adView.getStarRatingView().setVisibility(View.VISIBLE);
            ((RatingBar)adView.getStarRatingView()).setRating(nativeAd.getStarRating().floatValue());
        }

        if (nativeAd.getAdvertiser() == null){
            adView.getAdvertiserView().setVisibility(View.INVISIBLE);
        }else{
            adView.getAdvertiserView().setVisibility(View.VISIBLE);
            ((TextView)adView.getAdvertiserView()).setText(nativeAd.getAdvertiser());
        }
        adView.setNativeAd(nativeAd);
    }
}
