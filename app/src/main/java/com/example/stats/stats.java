package com.example.stats;

import android.database.Cursor;
import android.database.DatabaseUtils;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.SQL.DbContect;
import com.example.huixingzhen.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link stats#newInstance} factory method to
 * create an instance of this fragment.
 */
public class stats extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private TextView textview1;
    private  TextView textview2;
    private  TextView textview3;
    private  TextView textview4;
    private  TextView textview5;
    private  TextView textview6;
    private  TextView textview7;
    private  TextView textview8;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private DbContect dbhelper;

    public stats() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment stats.
     */
    // TODO: Rename and change types and number of parameters
    public static stats newInstance(String param1, String param2) {
        stats fragment = new stats();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_stats, container, false);
        textview1=view.findViewById(R.id.textView6);

        textview3=view.findViewById(R.id.textView9);
        textview4=view.findViewById(R.id.textView12);
        textview5=view.findViewById(R.id.textView13);
        textview6=view.findViewById(R.id.textView14);
        textview7=view.findViewById(R.id.textView15);
        textview8=view.findViewById(R.id.textView16)  ;
        setText();






        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        setText();
    }

    private  void setText(){
dbhelper=new DbContect(getActivity());
       dbhelper.getReadableDatabase();
        Cursor cur=dbhelper.query();
        int i = 0;
        while (cur.moveToNext()) {
            if(cur.getInt(cur.getColumnIndexOrThrow("_id"))!=0) {
                i += 1;
            }
        }
textview1.setText("当前笔记数目:"+i);
          i = 0;
        cur=dbhelper.query();
        while (cur.moveToNext()) {
            if(cur.getInt(cur.getColumnIndexOrThrow("reviewday_1"))!=0) {
                i += 1;
            }
        }

        textview3.setText("第一天复习的条数:"+i);
          i = 0;
        cur=dbhelper.query();
        while (cur.moveToNext()) {
            if(cur.getInt(cur.getColumnIndexOrThrow("reviewday_3"))!=0) {
                i += 1;
            }
        }
        textview4.setText("第三天复习的条数:"+i);
          i = 0;
        cur=dbhelper.query();
        while (cur.moveToNext()) {
            if(cur.getInt(cur.getColumnIndexOrThrow("reviewday_7"))!=0) {
                i += 1;
            }
        }
        textview5.setText("第七天复习的条数:"+i);
          i = 0;
        cur=dbhelper.query();
        while (cur.moveToNext()) {
            if(cur.getInt(cur.getColumnIndexOrThrow("reviewday_14"))!=0) {
                i += 1;
            }
        }
        textview6.setText("第十四天复习的条数:"+i);
          i = 0;
        cur=dbhelper.query();
        while (cur.moveToNext()) {
            if(cur.getInt(cur.getColumnIndexOrThrow("reviewday_21"))!=0) {
                i += 1;
            }
        }
        textview7.setText("第二十一天复习的条数:"+i);
          i = 0;
        cur=dbhelper.query();
        while (cur.moveToNext()) {
            if(cur.getInt(cur.getColumnIndexOrThrow("reviewday_30"))!=0) {
                i += 1;
            }
        }
        textview8.setText("第三十天复习的条数:"+i);




    }
}