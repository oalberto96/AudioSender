package com.computomovilyubicuo.audiosender.utilities;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.computomovilyubicuo.audiosender.MainActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.computomovilyubicuo.audiosender.MainActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by glassy on 11/11/17.
 */



public class NetworkUtils {

    public static final String HOST = "http://192.168.0.117/arduinodata";

    public String getBodyRequest(String humidity, String temperature) throws JSONException {
        JSONObject json = new JSONObject();
        json.put("humidity", Float.valueOf(humidity));
        json.put("temperature", Float.valueOf(temperature));
        return json.toString();
    }

    public StringRequest getRequest(final String humidity, final String temperature){

// Request a string response from the provided URL.

        StringRequest stringRequest = new StringRequest(Request.Method.POST, HOST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.d("Response ", response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.wtf("NetworkUtils: ",error.toString());
                    }

        }){
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                try {
                    String body = getBodyRequest(humidity, temperature);
                    Log.d("String:", body);

                    return body == null ? null : body.getBytes("utf-8");
                } catch (JSONException e) {
                    e.printStackTrace();
                    return null;
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        };
        return stringRequest;
    }

}
