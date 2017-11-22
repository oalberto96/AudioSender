package com.computomovilyubicuo.audiosender;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.computomovilyubicuo.audiosender.utilities.NetworkUtils;

public class MainActivity extends AppCompatActivity {

    TextView et_temperature;
    TextView et_humidity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_temperature = (EditText) findViewById(R.id.et_temperature);
        et_humidity = (EditText) findViewById(R.id.et_humidity);
    }

    protected void onBtnClick_sendfile(View v){
        sendFile();
    }


    protected void sendFile(){
        String humidity = et_humidity.getText().toString();
        String temperature = et_temperature.getText().toString();

        RequestQueue queue = Volley.newRequestQueue(this);
        NetworkUtils network_utils = new NetworkUtils();
        StringRequest str_request = network_utils.getRequest(humidity,temperature);
        queue.add(str_request);
    }
}
