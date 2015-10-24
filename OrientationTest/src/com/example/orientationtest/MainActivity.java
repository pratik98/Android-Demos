package com.example.orientationtest;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Configuration;
import android.util.Log;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
    	// TODO Auto-generated method stub
    	super.onConfigurationChanged(newConfig);
    	Log.d("Orientation", "Orientation changed");
    }
}
