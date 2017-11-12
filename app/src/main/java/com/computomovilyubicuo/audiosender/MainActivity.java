package com.computomovilyubicuo.audiosender;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.computomovilyubicuo.audiosender.utilities.NetworkUtils;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void onBtnClick_sendfile(View v){
        sendFile();
    }


    protected void sendFile(){
        RequestQueue queue = Volley.newRequestQueue(this);
        NetworkUtils network_utils = new NetworkUtils();
        StringRequest str_request = network_utils.getRequest();
        queue.add(str_request);
    }
}
