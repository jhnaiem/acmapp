package com.example.jahid.acm;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by jhasan on 1/12/17.
 */

public class Notice extends AppCompatActivity{


    private String textT;
    private String textD;
    private int imageid;

    public Notice(String textT, String textP, int imageid) {
        this.textT = textT;
        this.textD = textP;
        this.imageid = imageid;
    }

    public String getTextT() {
        return textT;
    }

    public String getTextP() {
        return textD;
    }

    public int getImageid() {
        return imageid;
    }
//    ListView elistview;
//    int[] imagesE={R.drawable.android_image_3};
//
//    String[] names={"Technovation"};
//    RecyclerView recyclerView;
//
//private View view;
//
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.eventsdesign);
//
//        this.getSupportFragmentManager().beginTransaction().add(R.id.container,new EventsFragment()).commit();
//
//    }
//
//
//    @SuppressLint("WrongViewCast")
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        view = inflater.inflate(R.layout.content, container, false);
//        initData();
//         recyclerView= view.findViewById(R.id.noticeitem);
//        NoticeFrag = new NoticeFrag(imagesE, getActivity());
//        viewPager.setAdapter(padapter);
//        return  view;
//    }

//    @SuppressLint("ResourceType")
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.id.noticeitem);
//
//        //Event
//        elistview= (ListView) findViewById(R.id.Event_list_view);
//        Notice.CustomAdapterE customAdapterE=new CustomAdapterE();
//        elistview.setAdapter(customAdapterE);
//    }
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
//        super.onCreate(savedInstanceState, persistentState);
//    }
//
//    class CustomAdapterE extends BaseAdapter {
//
//        @Override
//        public int getCount() {
//            return 0;
//        }
//
//        @Override
//        public Object getItem(int i) {
//            return null;
//        }
//
//        @Override
//        public long getItemId(int i) {
//            return 0;
//        }
//
//        @Override
//        public View getView(int position, View view, ViewGroup parent) {
//            View view2= getLayoutInflater().inflate(R.layout.layoutfornotice,null);
//
//            ImageView mImageview=view.findViewById(R.id.imageView3);
//            TextView mTextview= view.findViewById(R.id.textView2);
//            mImageview.setImageResource(imagesE[position]);
//            mTextview.setText(names[position]);
//
//
//            return view2;
//        }
//    }
}
