package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {
public static final String[] shuzu = new String[]{
            "Fragment Demo",
            "GridView Demo",
            "Recycler Demo",
            "排休表",
            "今日谁优先下班",
            "今日去机动人员",
            "我的支援工时",
            "拣选入门地图"
    };
    private ListView listView;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    public void toNewActivity(int position) {
        Intent i;
        switch (position) {
            case 0:
                i = new Intent(MainActivity.this,
                        FMainActivity.class);
                break;

            case 1:
                i = new Intent(MainActivity.this,
                        PrinterActivity.class);
                break;
            case 2:
                i = new Intent(MainActivity.this,GridActivity.class);
                break;

            default:
                i = new Intent(MainActivity.this, MainActivity.class);
        }
        startActivity(i);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.c01);
        listView = (ListView) findViewById(R.id.listview);

        listView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                shuzu));
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        toNewActivity(position);
                    }
                }
        );
    }
        public void jianyi(View view){
            Toast.makeText(MainActivity.this, "提出你宝贵的意见，我们会做的更好",Toast.LENGTH_SHORT).show();
        }}








