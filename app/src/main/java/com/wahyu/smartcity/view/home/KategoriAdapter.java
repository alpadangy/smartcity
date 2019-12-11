package com.wahyu.smartcity.view.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wahyu.smartcity.R;
import com.wahyu.smartcity.model.Kategori;

import java.util.List;

/**
 * Created by Ujang Wahyu on 12/10/2019.
 * PT Indocyber Global Teknologi
 * ujang.wahyu@indocyber.co.id
 */
public class KategoriAdapter extends RecyclerView.Adapter<KategoriAdapter.KategoriViewHolder> {
    private Context mContext;
    private List<Kategori> kategoriList;

    public class KategoriViewHolder extends RecyclerView.ViewHolder{

        private TextView tvNamaKategori;

        public KategoriViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaKategori = itemView.findViewById(R.id.tv_kategori);
        }
    }

    @NonNull
    @Override
    public KategoriViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lokasi, parent, false);
        return new KategoriViewHolder(itemView);
    }

    public KategoriAdapter(Context mContext, List<Kategori> kategoriList) {
        this.mContext = mContext;
        this.kategoriList = kategoriList;
    }

    @Override
    public void onBindViewHolder(@NonNull KategoriViewHolder holder, int position) {
        Kategori kategori = kategoriList.get(position);
        holder.tvNamaKategori.setText(kategori.getNamaKategori());

    }

    @Override
    public int getItemCount() {
        return kategoriList.size();
    }
}
