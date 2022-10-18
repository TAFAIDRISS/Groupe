package com.FiCallibCallib.callibvideoibfake.GetData;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.FiCallibCallib.callibvideoibfake.CustomUtil_lesLien.Lien_URL;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class GetData extends Application {

    public static RequestQueue requestQueue ;

    public static String ads = "admob" ;
    public static String BannerAdmob = "ca-app-pub-3940256099942544/6300978111" ;
    public static String IntersAdmob = "ca-app-pub-3940256099942544/1033173712" ;
    public static String NativeAdmob = "ca-app-pub-3940256099942544/2247696110" ;



    public void oneCreate(){
        super.onCreate();


    }
  public static void ConncetDataURL(Context context){

        requestQueue= Volley.newRequestQueue(context);

      JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, Lien_URL.URL_JS,
              null, new Response.Listener() {
          @Override
          public void onResponse(Object response) {

              try {
                  JSONObject jsonObject = ((JSONObject) response).getJSONObject("data");
                  JSONObject getdata = jsonObject.getJSONObject("connectData");

                  ads =getdata.getString("ads");
                  BannerAdmob =getdata.getString("bannerAdmob");
                  IntersAdmob = getdata.getString("IntersAdmob");
                  NativeAdmob = getdata.getString("NativeAdmob");

                  Log.e("ISSDN", "onResponse: " + response );
              } catch (JSONException e) {
                  e.printStackTrace();
              }


          }
      }, new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {


          }
      });
      jsonObjectRequest.setShouldCache(false);
      requestQueue.add(jsonObjectRequest);

  }
}

