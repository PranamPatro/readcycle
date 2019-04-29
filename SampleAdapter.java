package com.kritika.pranampatro.readcycle;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SampleAdapter extends RecyclerView.Adapter<SampleAdapter.SampleViewHolder>{

    private String[] data;

    public SampleAdapter(String[] data) {
        this.data = data;
    }

    @NonNull
    @Override
    public SampleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view =  inflater.inflate(R.layout.llayoutforbookselveshow,viewGroup,false);
        return new SampleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SampleViewHolder sampleViewHolder, int i) {
        String title = data[i];
        sampleViewHolder.bkname.setText(title);

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class SampleViewHolder extends RecyclerView.ViewHolder{
        TextView bkname,bkprice;
        public SampleViewHolder(@NonNull View itemView) {
            super(itemView);
            bkname = itemView.findViewById(R.id.bookname);
            bkprice = itemView.findViewById(R.id.bookprice);
        }
    }
}
