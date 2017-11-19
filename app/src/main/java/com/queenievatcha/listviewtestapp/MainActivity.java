package com.queenievatcha.listviewtestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] puppy = {"Frenchie", "Mini Bull Terrier", "Golden Retriever", "German Shepherd", "Chow Chow"};
        String[] description = {"This is a frenchie", "This is a mini bull terrier", "This is a golden retriever", "This is a german shepherd", "This is a chow chow"};
        Integer[] imgID = {R.drawable.frenchie, R.drawable.minibullterrier, R.drawable.goldenretriever,R.drawable.germanshepherd, R.drawable.chowchow};

        ListAdapter myAdapter = new CustomAdapter(this, puppy,description,imgID);
        ListView myListView = findViewById(R.id.myListView);
        myListView.setAdapter(myAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String puppy = String.valueOf(adapterView.getItemAtPosition(i));
                Toast.makeText(MainActivity.this, puppy, Toast.LENGTH_SHORT).show();
            }
        });

    }
    }
