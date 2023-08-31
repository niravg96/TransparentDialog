package com.example.transparentdialog;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RefundAdapter extends RecyclerView.Adapter {

    Context context;
    List<Boolean> list;
    String [] partnerName = {"Transaction 1","Transaction 2","Transaction 3","Transaction 4"};
    String [] status = {"In Progress","Completed","In Progress","Completed"};

    public RefundAdapter(Context context,List<Boolean> list) {
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_refund_activity,parent,false);
        RecyclerView.ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ViewHolder myholder = (ViewHolder) holder;
        myholder.partnerName.setText(partnerName[position]);


/*        if (status.equals("In process")){
            myholder.txt_status.setVisibility(View.VISIBLE);
            myholder.completed_image.setVisibility(View.GONE);
        }
        else if(status.equals("completed")){
            myholder.txt_status.setVisibility(View.GONE);
            myholder.completed_image.setVisibility(View.VISIBLE);
        }*/

        myholder.txt_status.setText(status[position]);

        if(myholder.txt_status.getText().toString() == "Completed")
        {
            myholder.txt_status.setVisibility(View.GONE);
            myholder.completed_image.setVisibility(View.VISIBLE);
        }
        myholder.seeDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                   // list.set(position,!list.get(position));
                    list.set(position,true);
                    notifyItemChanged(position);
             }
        });
        if (list.get(position))
        {
            myholder.seeDetails.setVisibility(View.GONE);
            myholder.track.setVisibility(View.VISIBLE);
        }
        else
        {
            myholder.seeDetails.setVisibility(View.VISIBLE);
            myholder.track.setVisibility(View.GONE);
        }
       /* for(int i =0;i<=position;i++)
        {
            list.set(position,false);
        }*/
    }
    @Override
    public int getItemCount() {
        return partnerName.length;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        RelativeLayout track;
        ImageView completed_image;
        TextView partnerName,transactionIdNo,price,txt_status,seeDetails;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            completed_image = itemView.findViewById(R.id.complete_logo);
            partnerName = itemView.findViewById(R.id.txtPartnerName);
            transactionIdNo = itemView.findViewById(R.id.txtTransactionID);
            price = itemView.findViewById(R.id.price);
            txt_status = itemView.findViewById(R.id.txtInProcess);
            seeDetails = itemView.findViewById(R.id.txtSeeDetails);
            track = itemView.findViewById(R.id.payment_track_lay);

            /*seeDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int pos = getAdapterPosition();

                    seeDetails.setVisibility(View.GONE);
                    track.setVisibility(View.VISIBLE);
                }
            });*/
        }
    }
}