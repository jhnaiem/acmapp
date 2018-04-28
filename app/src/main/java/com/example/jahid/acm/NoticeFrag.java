package com.example.jahid.acm;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.jahid.acm.model.Adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jhasan on 2/12/17.
 */

public class NoticeFrag extends Fragment {

    private View view;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.content, container, false);

        return  view;
    }


}
