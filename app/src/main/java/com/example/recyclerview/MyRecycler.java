package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;

public class MyRecycler extends RecyclerView.Adapter<MyRecycler.MyViewHolde>{
    String[] data;
    Context context;
    ToggleButton tB;
    TextView tV1, tV2;
    double n, d;
    public MyRecycler(Context context,TextView tV1, TextView tV2, String[] data, ToggleButton tB, double n, double d){
        this.data= data;
        this.context= context;
        this.tV1= tV1;
        this.tV2= tV2;
        this.n= n;
        this.d= d;
        this.tB = tB;
    }

    @NonNull
    @Override
    public MyViewHolde onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.custom_adp, parent, false);
        return MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecycler.MyViewHolde holder, int position) {
        holder.tV3.setText(data[position]);
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos=holder.getAdapterPosition();
                tV1.setText(data[pos]);
                if (tB.isChecked()){
                    tV2.setText(""+((2*n +pos*d)*(pos+1))/2);
                }
                else{
                    tV2.setText(""+n* (Math.pow(d,pos)));
                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return data.length;
    }

    public class MyViewHolde extends RecyclerView.ViewHolder {
        TextView tV2;
        LinearLayout mainLayout;
        public MyViewHolde(@NonNull View itemView) {
            super(itemView);
            tV3=itemView.findViewById(R.id.tV2);
            mainLayout=itemView.findViewById(R.id.mainLayout);
        }
    }

}
