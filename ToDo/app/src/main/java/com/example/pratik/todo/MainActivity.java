package com.example.pratik.todo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> items;
    ArrayAdapter<String> itemsAdapter;
    ListView lvItems;
    TodoDBHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lvItems = (ListView)findViewById(R.id.lvitem);
        // Get singleton instance of database
       databaseHelper = TodoDBHelper.getInstance(this);

        readItems();
        itemsAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
        lvItems.setAdapter(itemsAdapter);
        setListViewListener();

      /*  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    private void setListViewListener() {
        lvItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Item itemobj = new Item();
                itemobj.text = lvItems.getItemAtPosition(position).toString();
                databaseHelper.deleteItem(itemobj);
                items.remove(position);
                itemsAdapter.notifyDataSetChanged();
               // writeItems();
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onAddItem(View view) {
        EditText item = (EditText)findViewById(R.id.etNewitem);
        if(!item.getText().toString().isEmpty())
        {
            itemsAdapter.add(item.getText().toString());
            Item itemobj = new Item();
            itemobj.text = item.getText().toString();
            databaseHelper.addItem(itemobj);
            item.setText("");
        }

        else {
            Toast.makeText(this, "Nothing is not valid To Do item", Toast.LENGTH_SHORT).show();
        }


    }

    private void readItems() {
        /*
        Using files
        ============
        File filesdir = getFilesDir();
        File todofile = new File(filesdir,"todo.txt");
        try{
            items = new ArrayList<String>(FileUtils.readLines(todofile));
        }catch (IOException e)
        {
            items = new ArrayList<String>();
        }*/
        /*using Database*/
        for (String item : items = (ArrayList<String>) databaseHelper.getAllItems()) {
            Log.d("Item",item.toString());
        }
        ;


    }

    private void writeItems() {
      /*
       using files
       ===============
       File filesdir = getFilesDir();
        File todofile = new File(filesdir,"todo.txt");
        try{
           FileUtils.writeLines(todofile,items);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        */

    }
}
