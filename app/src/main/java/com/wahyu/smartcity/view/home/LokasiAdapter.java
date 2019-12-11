package com.wahyu.smartcity.view.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wahyu.smartcity.R;
import com.wahyu.smartcity.model.Lokasi;

import java.util.List;

public class LokasiAdapter extends RecyclerView.Adapter<LokasiAdapter.LokasiViewHolder> {
    private Context mContext;
    private List<Lokasi> lokasiList;

    public class LokasiViewHolder extends RecyclerView.ViewHolder{

        private TextView tvNamaLokasi;

        public LokasiViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaLokasi = itemView.findViewById(R.id.tv_kategori);
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
