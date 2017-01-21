package com.example.administrator.myapplication;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.LightingColorFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import static com.amap.api.mapcore.util.af.a.n;

/**
 * Created by Administrator on 2017/1/17.
 */

public class Sharedpreference extends AppCompatActivity {
    EditText ediyonghu;
    EditText edimima;
    TextView status;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.sharedpreference);
        ediyonghu = (EditText) findViewById(R.id.EdiYonghu);
        edimima = (EditText) findViewById(R.id.Edimima);
        status = (TextView) findViewById(R.id.status);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.denglu:
                Toast.makeText(this, "say", Toast.LENGTH_SHORT).show();
                break;


            case R.id.zhuce:
                String yonghu = ediyonghu.getText().toString();
                String mima = edimima.getText().toString();
                Editor editor = getEditor();
                editor.putString("yonghu", yonghu);
                editor.putString("mima", mima);
                editor.apply();
                Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.zhaohui:
                //.getString("savename","没有保存数据")第一个参数为文件内的name，方法的第二个参数为缺省值，如果SharedPreferences没有该参数，将返回缺省值
                SharedPreferences sp1 = getSharedPreferences("SP", MODE_PRIVATE);
                String spyonghu = sp1.getString("yonghu", "用户名为空");
                String spmima = sp1.getString("mima", "密码为空");
                status.setText("用户名:  " + spyonghu + "\n" + "密码:  " + spmima);

                break;
            case R.id.clean:
                //用clear()方法清除数据，commit()保存清除结果
                SharedPreferences sp2 = getSharedPreferences("SP", MODE_PRIVATE);
                Editor editor2 = sp2.edit();
                editor2.clear().apply();
                ediyonghu.setText("");
                edimima.setText("");

                Toast.makeText(this, "清除", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private Editor getEditor() {
        SharedPreferences sp = getSharedPreferences("SP", MODE_PRIVATE);
        return sp.edit();

    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Sharedpreference Page") // TODO: Define a title for the content shown.
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
}


