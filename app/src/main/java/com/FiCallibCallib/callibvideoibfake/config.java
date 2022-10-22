package com.FiCallibCallib.callibvideoibfake;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class config {
    //ads
    public static String unity_app_id;

    public static ArrayList<String> ads_array = new ArrayList<>();

    public static ArrayList<String> fb_inter_id = new ArrayList<>();





    public static ArrayList<String> banner_array = new ArrayList<>();;
    public static ArrayList<String> native_ads=new ArrayList<>();;

    public static ArrayList<String> fb_banner = new ArrayList<>();
    public static ArrayList<String> fb_native = new ArrayList<>();
    public static ArrayList<String> admob_n = new ArrayList<>();
    public static ArrayList<String> admob_bn = new ArrayList<>();
    public static ArrayList<String> admob_it = new ArrayList<>();
    public static ArrayList<String> admob_r = new ArrayList<>();


    public static String step1;
    public static String lockedlogo;
    public static String lockedtxt;
    public static String nothanks;
    public static String activatelocker;
    public static String lockertype;
    public static String sharetxt;
    public static String ratetype;
    public static long locker_delay_in_second;
    public static String cpalink;

    public static String own_native_link;
    public static String own_native_picture;
    public static String admob_appid;
    public static String admob_pub;
    public static boolean allow_native;
    public static boolean allow_banner;

    public static  Boolean test=true;

    public static String apploving_reward_id;
    public static String mopup_banner;
    public static String mopup_inter;
    public static String own_inter_link;
    public static String own_inter_picture;
    public static String own_banner_picture;
    public static String own_banner_link;
    public static String notificationlink;
    public static String notificationpicture;







    //social media
    public static String email;
    public static String youtube;
    public static String instagram;
    public static String developer;


    //app data
    public static int banned;
    public static String bannedlink;
    public static int enable_ownadsa_layout = 0;
    public static ArrayList<String> images = new ArrayList<>();
    public static ArrayList<String> myownasd = new ArrayList<>();
    public static String packagename;
    public static ArrayList<String> rewardlink = new ArrayList<>();
    public static int store = 0;
    public static String ownads_link;
    public static ArrayList<String> winimagelist = new ArrayList<>();

    public static int usersdata;

    public static String template;
    public static String index;
    public static String privacy;



    public static String link;
    public static double delay;
    public static int you;
    public static String shared_you;
    public static String step2;
    public static String step3;
    public static String step1type;
    public static String step2type;
    public static String step3type;
    public static Context contextg;

    public static String activate_button;
    public static String showbanner2;
//    public static ArrayList<content> precontent;
    public static int precontent_index=0;
//    public static ArrayList<content> list_of_content;
    public static boolean native_already_in_recycle=false;
    public static String imagemain;

    public static ArrayList<own_ads_model> owninter_array = new ArrayList<>();
    public static ArrayList<own_ads_model> ownbanner_array = new ArrayList<>();
    public static ArrayList<own_ads_model> ownnative_array = new ArrayList<>();
    public static String tapdaq_appid;
    public static String tapdaq_clientkey;
    public static String tapdaq_inter;
    public static String tapdaq_banner;
    public static String tapdaq_n;
    public static String tapdaq_reward;
    public static String tapdaq_autoreload;
    public static String deviceid;
    public static ArrayList<String> ads_array_reward= new ArrayList<>();


    public static String unity_bn_id;
    public static String unity_r_id;
    public static String unity_it_id;
    public static String lockedbg;
    public static ArrayList<String> fb_reward = new ArrayList<>();
    public static String ironsrc_APP_KEY;
    public static String apploving_inter;
    public static String apploving_banner;
    public static String apploving_native;
    public static String add_txt;
    public static String activate_own_ads;
    public static String rewardimage;
    public static String openapp;
    public static String leavematch_picture;
    public static String loti_minimal_loading;
    public static String loti_big_loading;

    public static void getdata(Context context){
         contextg = context;
        Response.Listener<String> response_listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Response",response);
                try {
                    JSONObject jsonArray = new JSONObject(response);
                    JSONObject objet = (JSONObject)  jsonArray.get("config");
                    config.ironsrc_APP_KEY=objet.getString("ironsrc_APP_KEY");
                    Log.e( "wiyhajar: ", objet.getString("admob_appid"));
                    config.admob_appid=objet.getString("admob_appid");
                    config.admob_appid=objet.getString("admob_appid");
                    config.admob_pub=objet.getString("admob_pub");
                    config.imagemain=objet.getString("imagemain");
                    config.add_txt=objet.getString("add_txt");
                    config.activate_own_ads=objet.getString("activate_own_ads");

                    openapp = objet.getString("open_app");
                    config.rewardimage=objet.getString("rewardimage");
                    config.apploving_native=objet.getString("apploving_native");
                    config.apploving_inter=objet.getString("apploving_inter");
                    config.apploving_banner=objet.getString("apploving_banner");
                    JSONArray fb_banner = (JSONArray)  objet.get("fb_banner");

                    for (int i = 0; i < fb_banner.length(); i++) {

                        config.fb_banner.add(String.valueOf(fb_banner.getString(i)));

                    }
                    JSONArray fb_reward = (JSONArray)  objet.get("fb_reward");

                    for (int i = 0; i < fb_reward.length(); i++) {

                        config.fb_reward.add(String.valueOf(fb_reward.getString(i)));

                    }
                    JSONArray fb_inter_id = (JSONArray)  objet.get("fb_inter_id");

                    for (int i = 0; i < fb_inter_id.length(); i++) {

                        config.fb_inter_id.add(String.valueOf(fb_inter_id.getString(i)));

                    }
                    JSONArray fb_native = (JSONArray)  objet.get("fb_native");

                    for (int i = 0; i < fb_native.length(); i++) {

                        config.fb_native.add(String.valueOf(fb_native.getString(i)));

                    }

                    config.tapdaq_autoreload=objet.getString("tapdaq_autoreload");
                    config.tapdaq_reward=objet.getString("tapdaq_reward");
                    config.tapdaq_appid=objet.getString("tapdaq_appid");
                    config.tapdaq_clientkey=objet.getString("tapdaq_clientkey");
                    config.tapdaq_inter=objet.getString("tapdaq_inter");
                    config.tapdaq_banner=objet.getString("tapdaq_banner");
                    config.tapdaq_n=objet.getString("tapdaq_n");

                    config.deviceid=objet.getString("deviceid");
                    config.precontent_index= Integer.parseInt(objet.getString("precontent_index"));


                    config.developer=objet.getString("developer");
                    config.email=objet.getString("email");

                    config.instagram=objet.getString("instagram");
                    config.banned= objet.getInt("banned");
                    config.bannedlink=objet.getString("link");
                    config.packagename=objet.getString("package");
                    config.privacy=objet.getString("privacy");
                    config.store=objet.getInt("store");
                    config.store= Integer.parseInt(objet.getString("store"));

                    config.unity_app_id=objet.getString("unity_app_id");
                    config.unity_bn_id=objet.getString("unity_bn_id");
                    config.unity_r_id=objet.getString("unity_r_id");
                    config.unity_it_id=objet.getString("unity_it_id");

                    config.leavematch_picture=objet.getString("leavematch_picture");
                    config.loti_minimal_loading=objet.getString("loti_minimal_loading");
                    config.loti_big_loading=objet.getString("loti_big_loading");





                    config.enable_ownadsa_layout=objet.getInt("ownads");
                    config.ownads_link=objet.getString("ownads_link");
                    config.youtube=objet.getString("youtube");
                    config.delay=objet.getDouble("delay");
                    config.template=objet.getString("template");
                    config.index=objet.getString("index");
                    config.you=objet.getInt("you");
                    config.activate_button=objet.getString("activate_button");
                    config.showbanner2=objet.getString("showbanner2");
                    JSONArray adar = (JSONArray)  objet.get("ads");

                    for (int i = 0; i < adar.length(); i++) {

                        config.ads_array.add(String.valueOf(adar.getString(i)));

                    }




                    JSONArray rewardarray = (JSONArray)  objet.get("ads_array_reward");

                    for (int i = 0; i < rewardarray.length(); i++) {

                        config.ads_array_reward.add(String.valueOf(rewardarray.getString(i)));
                    }



                    JSONArray bannered = (JSONArray)  objet.get("banner_ads");
                    config.banner_array.clear();
                    for (int i = 0; i < bannered.length(); i++) {

                        config.banner_array.add(String.valueOf(bannered.getString(i)));
                    }

                    JSONArray native_ads = (JSONArray)  objet.get("native_ads");

                    for (int i = 0; i < native_ads.length(); i++) {
                        config.native_ads.add(String.valueOf(native_ads.getString(i)));
                    }
///////////////////////
                    JSONArray flipper_image = (JSONArray)  objet.get("flipper_image");
                    config.images.clear();
                    for (int i = 0; i < flipper_image.length(); i++) {
                        config.images.add(String.valueOf(flipper_image.getString(i)));
                    }
                    JSONArray myownads = (JSONArray)  objet.get("myownads");
                    config.myownasd.clear();
                    for (int i = 0; i < myownads.length(); i++) {

                        config.myownasd.add(String.valueOf(myownads.getString(i)));
                    }


                    config.rewardlink.clear();
                    JSONArray rewardlink = (JSONArray)  objet.get("rewaard_link");

                    for (int i = 0; i < rewardlink.length(); i++) {

                        config.rewardlink.add(String.valueOf(rewardlink.getString(i)));
                    }




                    config.winimagelist.clear();

                    JSONArray winimagelist = (JSONArray)  objet.get("winimagelist");

                    for (int i = 0; i < winimagelist.length(); i++) {

                        config.winimagelist.add(String.valueOf(winimagelist.getString(i)));
                    }
                   // owninter_array
                    config.owninter_array.clear();

                    JSONArray owninter_array_objet = (JSONArray)  objet.get("owninter_array");

                    for (int i = 0; i < owninter_array_objet.length(); i++) {
                        own_ads_model model = new own_ads_model(owninter_array_objet.getJSONObject(i).getString("own_inter_link"),
                                owninter_array_objet.getJSONObject(i).getString("own_inter_picture") );
                        config.owninter_array.add(model);
                    }


                    config.ownbanner_array.clear();

                    JSONArray ownbanner_array_objet = (JSONArray)  objet.get("ownbanner_array");

                    for (int i = 0; i < ownbanner_array_objet.length(); i++) {
                        own_ads_model model = new own_ads_model(ownbanner_array_objet.getJSONObject(i).getString("own_banner_link"),
                                ownbanner_array_objet.getJSONObject(i).getString("own_banner_picture") );
                        config.ownbanner_array.add(model);
                    }


                    config.ownnative_array.clear();

                    JSONArray ownnative_array_objet = (JSONArray)  objet.get("ownnative_array");

                    for (int i = 0; i < ownnative_array_objet.length(); i++) {
                        own_ads_model model = new own_ads_model(ownnative_array_objet.getJSONObject(i).getString("own_native_link"),
                                ownnative_array_objet.getJSONObject(i).getString("own_native_picture") );
                        config.ownnative_array.add(model);
                    }


                    config.step1=objet.getString("step1");

                    config.lockedbg=objet.getString("lockedbg");
                    config.lockedlogo=objet.getString("lockedlogo");
                    config.lockedtxt=objet.getString("lockedtxt");
                    config.nothanks=objet.getString("nothanks");
                    config.activatelocker=objet.getString("activatelocker");
                 //   config.lockertype=objet.getString("lockertype");

                    config.sharetxt=objet.getString("sharetxt");
                    config.ratetype=objet.getString("ratetype");

                    config.locker_delay_in_second= Long.parseLong(objet.getString("locker_delay_in_second"));
                    config.cpalink=objet.getString("cpalink");


                    JSONArray admob_bn = (JSONArray)  objet.get("admob_bn");
                    config.admob_bn.clear();

                    for (int i = 0; i < admob_bn.length(); i++) {

                        config.admob_bn.add(String.valueOf(admob_bn.getString(i)));

                    }
                    JSONArray admob_it = (JSONArray)  objet.get("admob_it");

                    config.admob_it.clear();
                    for (int i = 0; i < admob_it.length(); i++) {

                        config.admob_it.add(String.valueOf(admob_it.getString(i)));

                    }
                    JSONArray admob_r = (JSONArray)  objet.get("admob_r");
                    config.admob_r.clear();
                    for (int i = 0; i < admob_r.length(); i++) {

                        config.admob_r.add(String.valueOf(admob_r.getString(i)));

                    }
                    JSONArray admob_n = (JSONArray)  objet.get("admob_n");
                    config.admob_n.clear();
                    for (int i = 0; i < admob_n.length(); i++) {

                        config.admob_n.add(String.valueOf(admob_n.getString(i)));

                    }


                    config.apploving_reward_id=objet.getString("apploving_reward_id");

                    config.own_inter_link=objet.getString("own_inter_link");
                    config.own_inter_picture=objet.getString("own_inter_picture");
                    config.own_banner_link=objet.getString("own_banner_link");
                    config.own_banner_picture=objet.getString("own_banner_picture");
                    config.notificationlink=objet.getString("notification_link");
                    config.notificationpicture=objet.getString("notification_picture");


                    config.own_native_link=objet.getString("own_native_link");
                    config.own_native_picture=objet.getString("own_native_picture");




                    config.mopup_banner=objet.getString("mopup_banner");
                    config.mopup_inter=objet.getString("mopup_inter");




                    config.step1type=objet.getString("step1type");
                    config.step2type=objet.getString("step2type");
                    config.step3type=objet.getString("step3type");
                    config.step2=objet.getString("step2");
                    config.step3=objet.getString("step3");





//                    for (int i = 0; i <config.ads_array.size() ; i++) {
//                        Log.e( "wiyhaarray: ", config.ads_array.get(i));
//
//                    }
//                    AdsServerData.interAds=jsonArray.getString("interAds");
//                    AdsServerData.nativeAds=jsonArray.getString("nativeAds");
//                    AdsServerData.opebAds=jsonArray.getString("OpebAds");
//                    AdsServerData.pubId=jsonArray.getString("PubId");
//                    AdsServerData.fBinterAds=jsonArray.getString("FBinterAds");
//                    AdsServerData.fBbanerAds=jsonArray.getString("FBbanerAds");
//                    AdsServerData.fBnativeAds=jsonArray.getString("FBnativeAds");
//                    Global.API_URL=jsonArray.getString("myPannel");
                } catch (JSONException e) {
                    Log.e( "tnakt: ", e.getMessage()+e.getCause());
                }
            }
        };


        Response.ErrorListener response_error_listener = new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e( "onErrorResponse: ",error.getMessage() );
                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                    //TODO
                } else if (error instanceof AuthFailureError) {
                    //TODO
                } else if (error instanceof ServerError) {
                    //TODO
                } else if (error instanceof NetworkError) {
                    //TODO
                } else if (error instanceof ParseError) {
                    //TODO
                }
            }
        };

        StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://younesjarhbou.github.io/don_fakecall.json",response_listener,response_error_listener);
        getRequestQueue().add(stringRequest);
    }

    public static RequestQueue getRequestQueue() {
        //requestQueue is used to stack your request and handles your cache.
        RequestQueue mRequestQueue = null;
        if (mRequestQueue == null) {

            mRequestQueue = Volley.newRequestQueue(contextg);
        }
        return mRequestQueue;
    }
}