package com.csc550.shoppinglist;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/*
Class SHOPPING LIST
 */
public class MainActivity extends AppCompatActivity {

    ArrayList<String> mList  = new ArrayList<String>();
    Button mButton;
    EditText mItem;
    ArrayAdapter<String> mAdapter;
    String LIST_KEY = "list";
    String TAG = "shoppinglist";

    /*
    onCreate
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Restore state
         */
        if (savedInstanceState != null) {
            mList = savedInstanceState.getStringArrayList(LIST_KEY);
        }

        /*
        Config Button
         */
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItem = (EditText) findViewById(R.id.editText);
                Context context = getApplicationContext();
                CharSequence text = mItem.getText().toString() + " was added";
                if (text.length() > 10) {
                    Log.d(TAG, "text length =" + text.length());
                    Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
                    mAdapter.add(mItem.getText().toString());
                    mItem.setText("");
                }
            }
        });

        /*
        create adapter & attach to Listview
         */
        mAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mList);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(mAdapter);

        /*
        Set item listener & attach to Listview
         */
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object obj = parent.getItemAtPosition(position);
                mAdapter.remove(obj.toString());
                Context context = getApplicationContext();
                CharSequence text = obj.toString() + " removed";
                Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
            }
        };
        listView.setOnItemClickListener(itemListener);

    } // end onCreate

    /*
    Save state on rotation
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putStringArrayList(LIST_KEY,mList);
    }

} // end class
