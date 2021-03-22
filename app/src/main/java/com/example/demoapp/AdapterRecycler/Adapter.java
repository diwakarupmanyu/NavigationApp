package com.example.demoapp.AdapterRecycler;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demoapp.Activity.DetailActivity;
import com.example.demoapp.Model.Model;
import com.example.demoapp.R;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>

{
    ArrayList<Model> data;

    public Adapter(ArrayList<Model> data)
            
    {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view= layoutInflater.inflate(R.layout.listitem,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        final Model temp = data.get(position);

        holder.name.setText(data.get(position).getName());
        holder.branch.setText(data.get(position).getBranch());
        holder.imageView.setImageResource(data.get(position).getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if(view.getContext() !=null) {
                    Intent intent = new Intent(view.getContext(), DetailActivity.class);
                    intent.putExtra("name", temp.getName());
                    intent.putExtra("branch", temp.getBranch());
                    intent.putExtra("image", temp.getImage());
                    view.getContext().startActivity(intent);
                }

            }
        });

    }

    @Override
    public int getItemCount()
    {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name,branch;

        public ViewHolder( View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.name);
            branch = itemView.findViewById(R.id.branch);
        }
    }


}
