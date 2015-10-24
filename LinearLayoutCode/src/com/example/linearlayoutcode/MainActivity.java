package com.example.linearlayoutcode;

import android.os.Bundle;
import android.app.Activity;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    LinearLayout ll;
    TextView t;
    Button b;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ll = new LinearLayout(this);
        t = new TextView(this);
        b = new Button(this);
        LayoutParams dimensions = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        ll.setLayoutParams(dimensions);
        LayoutParams viewdimension = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        t.setLayoutParams(viewdimension);
        b.setLayoutParams(viewdimension);
        
        ll.setOrientation(LinearLayout.VERTICAL);
        t.setText("Hello World");
        b.setText("Button");
        
        ll.addView(t);
        ll.addView(b);
        
        setContentView(ll);
    }

}
