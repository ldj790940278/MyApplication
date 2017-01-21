package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by Administrator on 2017/1/7.
 */

public class Fragment1 extends Fragment {
    String[] shuzu = new String[]{
            "0GridView Demo",
            "1WebView Demo",
            "2Recycler Demo",
            "3默认",
            "4今日谁优先下班",
            "5今日去机动人员",
            "6记忆之--sp",
            "7记忆之--SQlite"
    };

    public interface CallBack{
        public void xuanze(int position);
    }

    private ListView listView;

    public Fragment1(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view= inflater.inflate(R.layout.fragment1_layout , container, false);
        Button bt= (Button) view.findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),Zhu.class);
                startActivity(intent);
            }
        });

        listView = (ListView)view.findViewById(R.id.listview);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1 ,shuzu);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i;
                switch (position){
                    case 0:
                        i = new Intent(getActivity(),
                                GridActivity.class);
                        break;

                    case 1:
                        i = new Intent(getActivity(),
                                PrinterActivity.class);
                        break;
                    case 6:
                        i = new Intent(getActivity(),
                                Sharedpreference.class
                                );
                        break;


                    case 7:
                        i = new Intent(getActivity(),SqliteAC.class);
                        break;

                    default:
                        i = new Intent(getActivity(), Zhu.class);
                }
                startActivity(i);

            }


            });
        return view;}

        }











