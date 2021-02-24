package com.sauti.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.sauti.model.Model;
import com.sauti.scc.Offers;
import com.sauti.scc.R;

import java.util.ArrayList;

public class IndustryAdapter extends RecyclerView.Adapter<IndustryAdapter.ViewHolder> {
    public Context context;
    public ArrayList<Model> industryArrayList;
    Activity activity;

    public IndustryAdapter(Context context,ArrayList<Model> list,Activity activity){
        this.context =context;
        this.industryArrayList = list;
        this.activity = activity;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.bindList(industryArrayList.get(position));
        holder.popular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Model tags = industryArrayList.get(position);
                Intent intent = new Intent(context.getApplicationContext(), Offers.class);
                intent.putExtra("hashtags",tags);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return industryArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout popular;
        TextView popularTag;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            popularTag = itemView.findViewById(R.id.popularTag);
            popular = itemView.findViewById(R.id.popular);
        }

        public void bindList(Model popular) {
            popularTag.setText(popular.getTitle());
        }
    }
}
