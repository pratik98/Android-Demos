package com.example.framelayouttest;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MainActivity extends Activity {

	ImageView image1, image2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		image1 = (ImageView) findViewById(R.id.imageView1);
		image2 = (ImageView) findViewById(R.id.imageView2);
		
		OnClickListener obj = new OnClickListener() {
			public void onClick(View v) {
				if (v.getId() == R.id.imageView1) {
					image1.setVisibility(View.GONE);
					image2.setVisibility(View.VISIBLE);
				} else if (v.getId() == R.id.imageView2) {
					image2.setVisibility(View.GONE);
					image1.setVisibility(View.VISIBLE);
				}
			}
		};
		
		image1.setOnClickListener(obj);
		image2.setOnClickListener(obj);
	}
}