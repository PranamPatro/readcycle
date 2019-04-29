package com.kritika.pranampatro.readcycle;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

    public class MyAdapterForBookList extends RecyclerView.Adapter<MyAdapterForBookList.ViewHolder> {


        private List<listlayoutforbooklist> listItems;
        private Context context;

        public MyAdapterForBookList(List<listlayoutforbooklist> listItems, Context context) {
            this.listItems = listItems;
            this.context = context;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.llayoutforbookselveshow,viewGroup,false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

            listlayoutforbooklist listlayout = listItems.get(i);

            viewHolder.textbookname.setText(listlayout.getBookname());
            viewHolder.textbookprice.setText(listlayout.getBookprice());
        }

        @Override
        public int getItemCount() {
            return listItems.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{

            public TextView textbookname;
            public TextView textbookprice;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                textbookname = (TextView) itemView.findViewById(R.id.bookname);
                textbookprice = (TextView) itemView.findViewById(R.id.bookprice);

            }
        }
    }
