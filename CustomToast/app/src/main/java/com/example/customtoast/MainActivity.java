package com.example.customtoast;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void showCustomToast(View v) {
    	Toast toast = new Toast(this);
    	toast.setDuration(Toast.LENGTH_LONG);
    	LayoutInflater lin = getLayoutInflater();
    	View appearance = lin.inflate(R.layout.toast_layout,
    			(ViewGroup)findViewById(R.id.root));
		toast.setView(appearance);
    	toast.show();
	}
}
