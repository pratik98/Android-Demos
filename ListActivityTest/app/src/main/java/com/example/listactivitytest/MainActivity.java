package com.example.listactivitytest;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.ListActivity;

public class MainActivity extends ListActivity {

	ListView listView;
	String[] MyFiles = { "Android", "bluetooth", "download", "DCIM",
			"My Music", "My Videos", "My Documents", "ScreenCapture",
			"Whatsapp" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView = getListView();
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, MyFiles);
		listView.setAdapter(adapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// super.onListItemClick(l, v, position, id);
		TextView temp = (TextView) v;
		Toast.makeText(this, temp.getText() + " belongs to row " + position,
				Toast.LENGTH_SHORT).show();

	}

}
