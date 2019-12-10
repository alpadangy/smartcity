package com.wahyu.smartcity.view.wisata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wahyu.smartcity.R;
import com.wahyu.smartcity.model.Wisata;

import java.util.List;

/**
 * Created by Ujang Wahyu on 12/10/2019.
 * PT Indocyber Global Teknologi
 * ujang.wahyu@indocyber.co.id
 */

public class WisataAdapter extends RecyclerView.Adapter<WisataAdapter.WisataViewHolder> {
    private Context mContext;
    private List<Wisata> wisataList;

    public class WisataViewHolder extends RecyclerView.ViewHolder{

        private TextView tvNamaWisata, tvDeskripsi, tvLokasi;
        private ImageView imgCover;

        public WisataViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaWisata = itemView.findViewById(R.id.tv_nama_wisata);
            tvLokasi = itemView.findViewById(R.id.tv_lokasi);
            tvDeskripsi = itemView.findViewById(R.id.tv_deskripsi);
            imgCover = itemView.findViewById(R.id.img_cover);
        }
    }

    @NonNull
    @Override
    public WisataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_wisata, parent, false);
        return new WisataViewHolder(itemView);
    }

    public WisataAdapter(Context mContext, List<Wisata> wisataList) {
        this.mContext = mContext;
        this.wisataList = wisataList;
    }

    @Override
    public void onBindViewHolder(@NonNull WisataAdapter.WisataViewHolder holder, int position) {
        Wisata wisata = wisataList.get(position);
        holder.tvNamaWisata.setText(wisata.getNamaTempat());
        holder.tvLokasi.setText(wisata.getLokasi().getNamaLokasi());
        holder.tvDeskripsi.setText(wisata.getDeskripsi());
        Glide.with(mContext).load(wisata.getImageUrl()).into(holder.imgCover);

    }

    @Override
    public int getItemCount() {
        return wisataList.size();
    }
}
