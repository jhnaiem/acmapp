package com.example.jahid.acm.model;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jahid.acm.EventContent;
import com.example.jahid.acm.EventHistoryActivity;
import com.example.jahid.acm.MainActivity;
import com.example.jahid.acm.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by jhasan on 30/11/17.
 */

public class Adapter extends RecyclerView.Adapter {
    String[] items;
    Context context;
    List<EventContent> eventContentList;

    public Adapter(List<EventContent> eventContentList,Context context) {
        this.eventContentList = eventContentList;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(R.layout.custom_row, parent, false);
        return new ItemHolder(row);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        EventContent eventContent = eventContentList.get(position);

        Picasso.with(context).load(eventContent.getImageid()).resize(900, 300).into(((ItemHolder) holder).imageViewThumbnail);
        ((ItemHolder) holder).textViewTitle.setText(eventContent.getTextT());
        ((ItemHolder) holder).textViewDescription.setText(eventContent.getTextP());

        ((ItemHolder) holder).eventPanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = null;
                if(position == 0){
                    fragment = new Fragment();
                }else if(position == 1){
                    fragment = new Fragment();
                }
                ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction().add(R.id.container,fragment)
                        .addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return eventContentList.size();
    }
    public class  ItemHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle, textViewDescription;
        ImageView imageViewThumbnail;
        LinearLayout eventPanel;

        public ItemHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            imageViewThumbnail = itemView.findViewById(R.id.imageViewThumbnail);
            eventPanel = itemView.findViewById(R.id.eventPanel);
        }
    }
}
