package com.wahyu.smartcity.view.kuliner;

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
import com.wahyu.smartcity.model.Kuliner;

import java.util.List;

/**
 * Created by Ujang Wahyu on 12/10/2019.
 * PT Indocyber Global Teknologi
 * ujang.wahyu@indocyber.co.id
 */
public class KulinerAdapter extends RecyclerView.Adapter<KulinerAdapter.KulinerViewHolder> {
    private Context mContext;
    private List<Kuliner> kulinerList;

    public class KulinerViewHolder extends RecyclerView.ViewHolder{

        private TextView tvNamaToko, tvNamaLokasi, tvNamaJenis, tvNamaKuliner, tvDeskripsi, tvHarga;
        private ImageView imgCover;

        public KulinerViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaToko = itemView.findViewById(R.id.tv_nama_toko);
            tvNamaLokasi = itemView.findViewById(R.id.tv_nama_lokasi);
            tvNamaJenis = itemView.findViewById(R.id.tv_jenis);
            tvNamaKuliner = itemView.findViewById(R.id.tv_nama_kuliner);
            tvDeskripsi = itemView.findViewById(R.id.tv_deskripsi);
            tvHarga = itemView.findViewById(R.id.tv_harga);
            imgCover = itemView.findViewById(R.id.img_kuliner);
        }
    }

    @NonNull
    @Override
    public KulinerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_kuliner, parent, false);
        return new KulinerViewHolder(itemView);
    }

    public KulinerAdapter(Context mContext, List<Kuliner> kulinerList) {
        this.mContext = mContext;
        this.kulinerList = kulinerList;
    }

    @Override
    public void onBindViewHolder(@NonNull KulinerViewHolder holder, int position) {
        Kuliner kuliner = kulinerList.get(position);
        holder.tvNamaToko.setText(kuliner.getTempatkuliner().getNamaTempat());
        holder.tvNamaLokasi.setText(kuliner.getTempatkuliner().getLokasi());
        holder.tvNamaJenis.setText(kuliner.getJeniskuliner().getNamaJenis());
        holder.tvNamaKuliner.setText(kuliner.getNamaKuliner());
        holder.tvDeskripsi.setText(kuliner.getDeskripsi());
        holder.tvHarga.setText("Rp. 50.000");
        Glide.with(mContext).load(kuliner.getImageUrl()).into(holder.imgCover);

    }

    @Override
    public int getItemCount() {
        return kulinerList.size();
    }
}

