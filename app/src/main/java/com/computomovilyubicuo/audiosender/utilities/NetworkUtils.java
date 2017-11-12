package com.computomovilyubicuo.audiosender.utilities;
import android.util.Log;

import com.computomovilyubicuo.audiosender.MainActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.computomovilyubicuo.audiosender.MainActivity;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by glassy on 11/11/17.
 */



public class NetworkUtils {

    public static final String HOST = "http://10.0.0.2:8000";

    public StringRequest getRequest(){

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, HOST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.wtf("NetworkUtils: ","Error on response");
                    }
        });
        return stringRequest;
    }

}
