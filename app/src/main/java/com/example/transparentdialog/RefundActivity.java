package com.example.transparentdialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class RefundActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RefundAdapter refundAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refund_status);

        recyclerView = findViewById(R.id.refund_recycle);
        List<Boolean> list= new ArrayList<>();
        list.add(false);
        list.add(false);
        list.add(false);
        list.add(false);
        refundAdapter = new RefundAdapter(RefundActivity.this,list);
        recyclerView.setLayoutManager(new LinearLayoutManager(RefundActivity.this, LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(refundAdapter);
    }
}