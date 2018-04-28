package com.example.jahid.acm;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jahid.acm.model.Adapter;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by jhasan on 2/12/17.
 */

class AdapterNotice extends RecyclerView.Adapter {
    Context contextN;


    List<Notice> noticeContents;


    public AdapterNotice(List<Notice> noticeContents, Context contextN) {
        this.noticeContents = noticeContents;
        this.contextN = contextN;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(R.layout.layoutfornotice, parent, false);
        return new ItemHolder(row);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        Notice eventContent = noticeContents.get(position);
        ImageView imageView = ((ItemHolder) holder).imageViewN;
        Picasso.with(contextN).load(eventContent.getImageid()).resize(100, 100).into(imageView);
        ((AdapterNotice.ItemHolder) holder).textViewTitle.setText(eventContent.getTextT());
        ((AdapterNotice.ItemHolder) holder).textViewDescription.setText(eventContent.getTextP());

        ((ItemHolder) holder).noticelist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = null;
                if(position == 0){
                    fragment = new Fragment();
                }else if(position == 1){
                    fragment = new Fragment();
                }
                ((AppCompatActivity)contextN).getSupportFragmentManager().beginTransaction().add(R.id.container,fragment)
                        .addToBackStack(null).commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return noticeContents.size();
    }


    public class  ItemHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle, textViewDescription;
        ImageView imageViewN;
        RelativeLayout noticelist;

        public ItemHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textView2);
            textViewDescription = itemView.findViewById(R.id.descrip2);
            imageViewN = itemView.findViewById(R.id.imageView3);
            noticelist = itemView.findViewById(R.id.noticelist);
        }
    }
}
