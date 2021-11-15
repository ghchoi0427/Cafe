package com.choi.cafe.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.choi.cafe.R;
import com.choi.cafe.data.model.Merchandise;
import com.choi.cafe.databinding.ItemMerchandiseBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MerchandiseAdapter extends RecyclerView.Adapter<MerchandiseViewHolder<ItemMerchandiseBinding>> {
    private ArrayList<Merchandise> merchandises = new ArrayList<>();

    public ArrayList<Merchandise> getMerchandises() {
        return merchandises;
    }

    public void setMerchandises(ArrayList<Merchandise> merchandises) {
        this.merchandises = merchandises;
    }

    public void updateItems(ArrayList<Merchandise> merchandiseList) {
        MerchandiseItemDiffCallBack callback = new MerchandiseItemDiffCallBack(this.merchandises, merchandiseList);
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(callback);

        this.merchandises.clear();
        this.merchandises.addAll(merchandiseList);
        result.dispatchUpdatesTo(this);
    }

    @NonNull
    @NotNull
    @Override
    public MerchandiseViewHolder<ItemMerchandiseBinding> onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new MerchandiseViewHolder<>(inflater.inflate(R.layout.item_merchandise, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MerchandiseViewHolder<ItemMerchandiseBinding> holder, int position) {
        holder.binding().setMerchandise(merchandises.get(position));
    }

    @Override
    public int getItemCount() {
        return merchandises.size();
    }
}
