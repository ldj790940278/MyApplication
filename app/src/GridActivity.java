package com.example.administrator.myapplication;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.administrator.myapplication.MainActivity.shuzu;

/**
 * Created by Administrator on 2016/12/24 0024.
 */
public class GridActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private GridView grid_test;
    private ListView listView02;


    private List<Map<String, Object>> dataList;
    private SimpleAdapter sim1;
    private int[] img = {R.drawable.xie, R.drawable.shezhi, R.drawable.ic3,
            R.drawable.shezhi, R.drawable.xie};
    private String[] imgName = {"写下", "设置", "图标", "设置", "图标"
    };
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kadanactivity);
        grid_test = (GridView) findViewById(R.id.grid_test);
        // step1
        dataList = new ArrayList<Map<String, Object>>(); // step2
        listView02= (ListView) findViewById(R.id.listview02);
        listView02.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                shuzu));
        sim1 = new SimpleAdapter(this, getData(), R.layout.grid_item,
                new String[]{"img", "txt"}, new int[]{R.id.img_item, R.id.txt_item});
        grid_test.setAdapter(sim1); // step3
        grid_test.setOnItemClickListener(this);


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    private List<Map<String, Object>> getData() {
        for (int i = 0; i < img.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("img", img[i]);
            map.put("txt", imgName[i]);
            dataList.add(map);
        }
        return dataList;
    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Kadan Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        Toast.makeText(GridActivity.this, "你点击了"+arg2,Toast.LENGTH_SHORT).show();

}}


