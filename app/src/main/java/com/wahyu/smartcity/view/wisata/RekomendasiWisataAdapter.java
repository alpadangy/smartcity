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

public class RekomendasiWisataAdapter extends RecyclerView.Adapter<RekomendasiWisataAdapter.WisataViewHolder> {
    private Context mContext;
    private List<Wisata> wisataList;

    public class WisataViewHolder extends RecyclerView.ViewHolder{

        private TextView tvNamaLokasi;
        private ImageView imgCover;

        public WisataViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaLokasi = itemView.findViewById(R.id.tv_nama_tempat);
            imgCover = itemView.findViewById(R.id.img_cover);
        }
    }

    @NonNull
    @Override
    public WisataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rekomendasi_wisata, parent, false);
        return new WisataViewHolder(itemView);
    }

    public RekomendasiWisataAdapter(Context mContext, List<Wisata> wisataList) {
        this.mContext = mContext;
        this.wisataList = wisataList;
    }

    @Override
    public void onBindViewHolder(@NonNull WisataViewHolder holder, int position) {
        Wisata wisata = wisataList.get(position);
        holder.tvNamaLokasi.setText(wisata.getNamaTempat());
        Glide.with(mContext).load(wisata.getImageUrl()).into(holder.imgCover);

    }

    @Override
    public int getItemCount() {
        return wisataList.size();
    }
}
