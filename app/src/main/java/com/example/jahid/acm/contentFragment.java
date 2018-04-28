package com.example.jahid.acm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jahid on 11/4/17.
 */

public  class contentFragment extends Fragment{

    //HorizontalInfiniteCycleViewPager viewPager;
    //List<Integer> lstImages = new ArrayList<>();
    private View view;
    RecyclerView recyclerView;



    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.content, container, false);
        //initData();
        //viewPager = view.findViewById(R.id.horizontal_cycle);
        ////padapter padapter = new padapter(lstImages, getActivity());
        //viewPager.setAdapter(padapter);
        recyclerView = view.findViewById(R.id.Event_list_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new AdapterNotice(getNoticeContents(),getActivity()));
        return  view;
    }



    private List<Notice> getNoticeContents() {
        List<Notice> NoticeContentslist = new ArrayList<>();
        NoticeContentslist.add(new Notice("this is notice title","this is short discription",R.drawable.android_image_3));

        return NoticeContentslist;
    }

//    private void initData() {
//        lstImages.add(R.drawable.android_image_3);
//        lstImages.add(R.drawable.android_image_4);
//        lstImages.add(R.drawable.logo);
//    }





}

