package com.example.jahid.acm.Adapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jahid.acm.AdvisorActivity;
import com.example.jahid.acm.PieChartActivity;
import com.example.jahid.acm.R;
import com.example.jahid.acm.model.itemof;
import com.github.aakira.expandablelayout.ExpandableLayoutListenerAdapter;
import com.github.aakira.expandablelayout.ExpandableLinearLayout;
import com.github.aakira.expandablelayout.Utils;

import java.util.List;

/**
 * Created by jAHID on 11/10/2017.
 */

class MyViewHolderWihtoutChild extends RecyclerView.ViewHolder{
    public TextView textView;


    public MyViewHolderWihtoutChild(View itemView) {
        super(itemView);
        textView= (TextView)itemView.findViewById(R.id.textView);
    }
}

class MyViewHolderWihtChild extends RecyclerView.ViewHolder{
    public TextView textView,textViewChild,textViewChild2;
    public RelativeLayout button;
    public ExpandableLinearLayout expandableLayout;
    RelativeLayout parentPanel;

    public MyViewHolderWihtChild(View itemView) {
        super(itemView);
        textView= (TextView)itemView.findViewById(R.id.textView);
        textViewChild=(TextView)itemView.findViewById(R.id.textViewChild1);
        textViewChild2=(TextView)itemView.findViewById(R.id.textViewChild2);
        button =(RelativeLayout)itemView.findViewById(R.id.button);
        expandableLayout=(ExpandableLinearLayout)itemView.findViewById(R.id.expandableLayout);
        parentPanel = itemView.findViewById(R.id.parentPanel);
    }
}

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    List<itemof>items;
    Context context;
    SparseBooleanArray expandSate=new SparseBooleanArray();
    public MyAdapter(List<itemof> items){
        this.items=items;
        for (int i=0;i<items.size();i++)
            expandSate.append(i,false);
    }

    @Override
    public int getItemViewType(int position) {
        if(items.get(position).isExpan())
            return 1;
        else
            return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       this.context=parent.getContext();
        if (viewType==0)
        {
            LayoutInflater inflater=LayoutInflater.from(context);
            View view=inflater.inflate(R.layout.without_child,parent,false);

            return  new MyViewHolderWihtoutChild(view);

        }
        else
        {
            LayoutInflater inflater=LayoutInflater.from(context);
            View view=inflater.inflate(R.layout.with_child,parent,false);

            return  new MyViewHolderWihtChild(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {


        switch ( holder.getItemViewType()){

            case 0:
            {
                MyViewHolderWihtoutChild viewHolder=(MyViewHolderWihtoutChild)holder;
                itemof item=items.get(position);
                //viewHolder.setIsRecyclable(false);
               viewHolder.textView.setText(item.getText());
                viewHolder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                break;
            }

            case 1:
            {
                final MyViewHolderWihtChild viewHolder=(MyViewHolderWihtChild)holder;
                itemof item=items.get(position);
                viewHolder.setIsRecyclable(false);
                viewHolder.textView.setText(item.getText());
                viewHolder.expandableLayout.setInRecyclerView(true);
                viewHolder.expandableLayout.setExpanded(false);
                viewHolder.expandableLayout.setListener(new ExpandableLayoutListenerAdapter() {



                    @Override
                    public void onAnimationStart() {

                    }

                    @Override
                    public void onAnimationEnd() {

                    }

                    @Override
                    public void onPreOpen() {
                        changeRotate(viewHolder.button,0f,180f).start();
                        expandSate.put(position,true);

                    }

                    @Override
                    public void onPreClose() {
                        changeRotate(viewHolder.button,180f,0f).start();
                        expandSate.put(position,false);


                    }


                });


                viewHolder.button.setRotation(expandSate.get(position)?180f:0f);
                viewHolder.parentPanel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //expandable child item
                        viewHolder.expandableLayout.toggle();
                    }
                });
                ///   set the fragments for the buttons ....

                viewHolder.textViewChild.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

///   set the activities for the buttons ....
               viewHolder.textViewChild.setText(items.get(position).getSubtext());
                viewHolder.textViewChild.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        if(position==0){
                        Intent intent = new Intent(context, AdvisorActivity.class);
                        context.startActivity(intent);


                        }
                        if (position==1){


                        }

                    }

                    public void onClick() {
                    }
                });
                viewHolder.textViewChild2.setText(items.get(position).getSubtext2());
                viewHolder.textViewChild2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (position==0){

                        }
                        else if (position==1){
                            Intent intent;
                            intent = new Intent(context, PieChartActivity.class);
                            context.startActivity(intent);
                        }

                    }
                });
                break;

            }
            default:
                break;
        }
    }

    private ObjectAnimator changeRotate(RelativeLayout button, float from, float to) {
               ObjectAnimator animator =ObjectAnimator.ofFloat(button,"rotation",from,to);
        animator.setDuration(300);
        animator.setInterpolator(Utils.createInterpolator(Utils.LINEAR_INTERPOLATOR));
        return animator;
    }

    @Override
    public int getItemCount() {

        return items.size();
    }
}
