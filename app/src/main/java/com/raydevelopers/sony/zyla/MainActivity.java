package com.raydevelopers.sony.zyla;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.raydevelopers.sony.zyla.adapters.VerticalRecyclerViewAdapter;
import com.raydevelopers.sony.zyla.models.SongDetails;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    ArrayList<SongDetails> list;
    RecyclerView recyclerView;
    VerticalRecyclerViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        recyclerView=(RecyclerView)findViewById(R.id.vertical_rv);
        Spinner spinnerNum=(Spinner)findViewById(R.id.spinner_songs_num);
        Integer[] items = new Integer[]{1,2,3,4,5};
        ArrayAdapter<Integer> numAdapter=new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_item,items);
        spinnerNum.setAdapter(numAdapter);

        Spinner spinnerArtist=(Spinner)findViewById(R.id.spinner_artist);
        String[] category=new String[]{"Artist","Album"};
        ArrayAdapter<String> catAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,category);
        spinnerArtist.setAdapter(catAdapter);




        setSupportActionBar(toolbar);
        try {
            InputStream inputStream=getAssets().open("sample_music_data.csv");
            ReadCSVFile csvFile=new ReadCSVFile(inputStream);
            list=csvFile.read();

        } catch (IOException e) {
            e.printStackTrace();
        }
        LinearLayoutManager l=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(l);
adapter=new VerticalRecyclerViewAdapter(this,list);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

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

        return super.onOptionsItemSelected(item);
    }
}
