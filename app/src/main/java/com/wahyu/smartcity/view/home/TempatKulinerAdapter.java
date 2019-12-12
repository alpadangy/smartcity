package com.wahyu.smartcity.view.home;

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
import com.wahyu.smartcity.model.Tempatkuliner;

import java.util.List;

/**
 * Created by Ujang Wahyu on 12/10/2019.
 * PT Indocyber Global Teknologi
 * ujang.wahyu@indocyber.co.id
 */
public class TempatKulinerAdapter extends RecyclerView.Adapter<TempatKulinerAdapter.KulinerViewHolder> {
    private Context mContext;
    private List<Tempatkuliner> tempatkulinerList;

    public class KulinerViewHolder extends RecyclerView.ViewHolder{

        private TextView tvNamaToko, tvNamaLokasi, tvWaktuBuka, tvWaktuTutup;
        private ImageView imgCover;

        public KulinerViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaToko = itemView.findViewById(R.id.tv_nama_tempat);
            tvNamaLokasi = itemView.findViewById(R.id.tv_lokasi);
            tvWaktuBuka = itemView.findViewById(R.id.tv_waktu_buka);
            tvWaktuTutup = itemView.findViewById(R.id.tv_waktu_tutup);
            imgCover = itemView.findViewById(R.id.img_kuliner);
        }
    }

    @NonNull
    @Override
    public KulinerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tempat_kuliner, parent, false);
        return new KulinerViewHolder(itemView);
    }

    public TempatKulinerAdapter(Context mContext, List<Tempatkuliner> tempatkuliners) {
        this.mContext = mContext;
        this.tempatkulinerList = tempatkuliners;
    }

    @Override
    public void onBindViewHolder(@NonNull KulinerViewHolder holder, int position) {
        Tempatkuliner tempatkuliner = tempatkulinerList.get(position);
        holder.tvNamaToko.setText(tempatkuliner.getNamaTempat());
        holder.tvNamaLokasi.setText(tempatkuliner.getLokasi());
        holder.tvWaktuBuka.setText(tempatkuliner.getWaktuBuka());
        holder.tvWaktuTutup.setText(tempatkuliner.getWaktuTutup());
        Glide.with(mContext).load(tempatkuliner.getImageUrl()).into(holder.imgCover);

    }

    @Override
    public int getItemCount() {
        return tempatkulinerList.size();
    }
}

