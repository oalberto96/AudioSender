package com.computomovilyubicuo.audiosender;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.computomovilyubicuo.audiosender.utilities.NetworkUtils;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class MainActivity extends AppCompatActivity {
    Switch sw_fan;
    Switch sw_water;
    Switch sw_light;

    TextView et_temperature;
    TextView et_humidity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_temperature = (EditText) findViewById(R.id.et_temperature);
        et_humidity = (EditText) findViewById(R.id.et_humidity);
        sw_fan = (Switch) findViewById(R.id.swt_fan);
        sw_water = (Switch) findViewById(R.id.swt_water);
        sw_light = (Switch) findViewById(R.id.swt_light);
    }

    protected void onBtnClick_sendfile(View v){
        sendFile();
    }

    protected void getInfo(View v){
        getActuators();
    }
    protected void getActuators(){
        RequestQueue queue = Volley.newRequestQueue(this);
        final NetworkUtils network_utils = new NetworkUtils();
        StringRequest str_request = network_utils.getGetRequest();

        queue.add(str_request);
        queue.addRequestFinishedListener(new RequestQueue.RequestFinishedListener<Object>() {

            @Override
            public void onRequestFinished(Request<Object> request) {
                parseJSON(network_utils.getResponse());
            }
        });
    }

    protected void parseJSON(String parse){
        try {
            JSONObject json = new JSONObject(parse);
            String light = json.get("light").toString();
            String water = json.get("water").toString();
            String fan = json.get("fan").toString();
            turnOnOffSwitch(sw_water, water);
            turnOnOffSwitch(sw_fan,fan);
            turnOnOffSwitch(sw_light, light);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected void turnOnOffSwitch(Switch swt, String status){
        if (status.equals("Activado")){
            swt.setChecked(true);
        }
        else {
            swt.setChecked(false);
        }
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
