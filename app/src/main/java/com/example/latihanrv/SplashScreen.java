package com.example.latihanrv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.example.latihanrv.Welcome.Welcome;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
                if (sp.getBoolean("welcome",false)){
                    Intent i = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(i);
                }else{
                    SharedPreferences.Editor ed = sp.edit();
                    ed.putBoolean("welcome",true);
                    ed.apply();
                    Intent i = new Intent(SplashScreen.this, Welcome.class);
                    startActivity(i);
                }
                finish();
            }
        }, 2000);
    }
}