package com.adgvit.task4;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>
{
    List<data> listitems;
    Context context;

    public MyAdapter(List<data> listitems, Context context)
    {
        this.listitems = listitems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
       View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rowlayout,viewGroup,false);
       return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i)
    {
        data item=listitems.get(i);
        viewHolder.textView.setText(item.name);
        String a=item.getUrl();
        Glide.with(context).load(a).into(viewHolder.imageView);
    }

    @Override
    public int getItemCount()
    {
        return listitems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView textView;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            textView=itemView.findViewById(R.id.tv);
            imageView=(ImageView)itemView.findViewById(R.id.iv);
        }
    }
}
