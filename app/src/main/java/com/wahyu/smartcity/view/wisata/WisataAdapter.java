package com.wahyu.smartcity.view.wisata;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wahyu.smartcity.R;
import com.wahyu.smartcity.model.Wisata;
import com.wahyu.smartcity.view.detailwisata.DetailWisataActivity;

import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

/**
 * Created by Ujang Wahyu on 12/10/2019.
 * PT Indocyber Global Teknologi
 * ujang.wahyu@indocyber.co.id
 */

public class WisataAdapter extends RecyclerView.Adapter<WisataAdapter.WisataViewHolder> {
    private Context mContext;
    private List<Wisata> wisataList;

    public class WisataViewHolder extends RecyclerView.ViewHolder{

        private TextView tvNamaWisata, tvDeskripsi, tvLokasi, tvJamBuka, tvJamTutup, tvWebsite;
        private ImageView imgCover;

        public WisataViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaWisata = itemView.findViewById(R.id.tv_nama_wisata);
            tvLokasi = itemView.findViewById(R.id.tv_nama_lokasi);
            tvDeskripsi = itemView.findViewById(R.id.tv_deskripsi);
            tvJamBuka = itemView.findViewById(R.id.tv_waktu_buka);
            tvJamTutup = itemView.findViewById(R.id.tv_waktu_tutup);
            tvWebsite = itemView.findViewById(R.id.tv_website);
            imgCover = itemView.findViewById(R.id.img_cover);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "List ke " + getPosition() + " di klik.");
                    Intent intent = new Intent(v.getContext(), DetailWisataActivity.class);
                    intent.putExtra("id_wisata", wisataList.get(getPosition()).getId());
                    intent.putExtra("nama_wisata", wisataList.get(getPosition()).getNamaTempat());
                       v.getContext().startActivity(intent);
                }
            });
        }
    }

    @NonNull
    @Override
    public WisataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_wisata_row, parent, false);
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
        holder.tvJamBuka.setText(wisata.getWaktuBuka());
        holder.tvJamTutup.setText(wisata.getWaktuTutup());
        holder.tvWebsite.setText(wisata.getWebsite());
        Glide.with(mContext).load(wisata.getImageUrl()).into(holder.imgCover);

    }

    @Override
    public int getItemCount() {
        return wisataList.size();
    }
}
