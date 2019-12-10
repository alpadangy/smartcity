package com.wahyu.smartcity.view.penginapan;

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
import com.wahyu.smartcity.model.Penginapan;

import java.util.List;

/**
 * Created by Ujang Wahyu on 12/10/2019.
 * PT Indocyber Global Teknologi
 * ujang.wahyu@indocyber.co.id
 */
public class PenginapanAdapter extends RecyclerView.Adapter<PenginapanAdapter.PenginapanViewHolder> {
    private Context mContext;
    private List<Penginapan> penginapanList;

    public class PenginapanViewHolder extends RecyclerView.ViewHolder{

        private TextView tvNamaPenginapan, tvDeskripsi, tvNamaLokasi, tvWaktuBuka, tvWaktuTutup, tvHarga;
        private ImageView imgCover;

        public PenginapanViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaPenginapan = itemView.findViewById(R.id.tv_nama_penginapan);
            tvDeskripsi = itemView.findViewById(R.id.tv_deskripsi);
            tvNamaLokasi = itemView.findViewById(R.id.tv_nama_lokasi);
            tvWaktuBuka = itemView.findViewById(R.id.tv_waktu_buka);
            tvWaktuTutup = itemView.findViewById(R.id.tv_waktu_tutup);
            tvHarga = itemView.findViewById(R.id.tv_harga);
            imgCover = itemView.findViewById(R.id.img_cover);
        }
    }

    @NonNull
    @Override
    public PenginapanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_penginapan, parent, false);
        return new PenginapanViewHolder(itemView);
    }

    public PenginapanAdapter(Context mContext, List<Penginapan> penginapanList) {
        this.mContext = mContext;
        this.penginapanList = penginapanList;
    }

    @Override
    public void onBindViewHolder(@NonNull PenginapanViewHolder holder, int position) {
        Penginapan penginapan = penginapanList.get(position);
        holder.tvNamaPenginapan.setText(penginapan.getNamaPenginapan());
        holder.tvDeskripsi.setText(penginapan.getDeskripsi());
        holder.tvNamaLokasi.setText(penginapan.getLokasi().getNamaLokasi());
        holder.tvWaktuBuka.setText(penginapan.getWaktuBuka());
        holder.tvWaktuTutup.setText(penginapan.getWaktuTutup());
        holder.tvHarga.setText(penginapan.getHarga());
        Glide.with(mContext).load(penginapan.getImageUrl()).into(holder.imgCover);

    }

    @Override
    public int getItemCount() {
        return penginapanList.size();
    }
}
