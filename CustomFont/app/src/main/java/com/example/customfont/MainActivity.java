package com.example.customfont;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Typeface;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView t;
		t = (TextView) findViewById(R.id.textView1);
		Typeface customfont = Typeface.createFromAsset(getAssets(), "fonts/ASMAN.TTF");
		t.setTypeface(customfont);
		
	}
}