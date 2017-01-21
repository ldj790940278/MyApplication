package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class search extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        textView = (TextView) findViewById(R.id.tx);
    }
    public void if1(View view){
        textView.setText("默认：缠绕膜                                   顺丰：泡沫箱+纸箱");
        textView.setTextSize(20);
    }
}
