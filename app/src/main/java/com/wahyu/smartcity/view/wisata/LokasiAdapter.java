package com.wahyu.smartcity.view.wisata;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.wahyu.smartcity.R;
import com.wahyu.smartcity.model.Lokasi;
import com.wahyu.smartcity.model.Wisata;
import com.wahyu.smartcity.view.detailwisata.DetailWisataActivity;

import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class LokasiAdapter extends RecyclerView.Adapter<LokasiAdapter.LokasiViewHolder> {
    private Context mContext;
    private List<Lokasi> lokasiList;

    public class LokasiViewHolder extends RecyclerView.ViewHolder{

        private TextView tvNamaLokasi;

        public LokasiViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaLokasi = itemView.findViewById(R.id.tv_kategori);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }

    @NonNull
    @Override
    public LokasiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lokasi, parent, false);
        return new LokasiViewHolder(itemView);
    }

    public LokasiAdapter(Context mContext, List<Lokasi> lokasiList) {
        this.mContext = mContext;
        this.lokasiList = lokasiList;
    }

    @Override
    public void onBindViewHolder(@NonNull LokasiViewHolder holder, int position) {
        Lokasi lokasi = lokasiList.get(position);
        holder.tvNamaLokasi.setText(lokasi.getNamaLokasi());

    }

    @Override
    public int getItemCount() {
        return lokasiList.size();
    }
}
