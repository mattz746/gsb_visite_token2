package com.example.gsb_visite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>   {


    private List<Praticien> dataModelListPraticiens;

    public RecyclerViewAdapter(List<Praticien> dataModelListPraticiens) {
        this.dataModelListPraticiens = dataModelListPraticiens;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView textViewPraticiensNom;
        TextView textViewPraticiensPrenom;

        public RecyclerViewHolder(@NonNull View itemView){
            super(itemView);
            textViewPraticiensNom = itemView.findViewById(R.id.textViewPraticiensNom);
            textViewPraticiensPrenom = itemView.findViewById(R.id.textViewPraticienPrenom);

        }

    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerViewHolder viewHolder;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_praticiens, parent, false);
        viewHolder = new RecyclerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.textViewPraticiensNom.setText(String.valueOf(dataModelListPraticiens.get(position).getNom()));
        holder.textViewPraticiensPrenom.setText(String.valueOf(dataModelListPraticiens.get(position).getPrenom()));
    }

    @Override
    public int getItemCount() {
        return dataModelListPraticiens.size();
    }
    public long getItemId(int position){
        return super.getItemId(position);
    }


}
