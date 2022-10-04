package com.t2009e.class3navigation;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.t2009e.class3navigation.listview.CustomListAdapter;
import com.t2009e.class3navigation.listview.ListItem;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    ListView listJob;
    CustomListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        setVariables();

        // ListView Adapter

    }

    void setVariables() {
        this.listJob = (ListView) findViewById(R.id.listJobs);

        //data
        this.adapter = new CustomListAdapter( this, initJobs() );

        //set data into ListView
        this.listJob.setAdapter( this.adapter );
    }

    List<ListItem> initJobs() {
        List<ListItem> list = new ArrayList<>();

        list.add(new ListItem("Java Dev", "Team leader", "Ha noi"));
        list.add(new ListItem("C# Dev", "Dev leader", "Ha noi"));
        list.add(new ListItem("C++ Dev", "Dev leader", "Ha noi"));
        list.add(new ListItem("Node Dev", "Dev leader", "Ha noi"));
        list.add(new ListItem("PHP Dev", "Dev leader", "Ha noi"));

        return list;
    }
}
