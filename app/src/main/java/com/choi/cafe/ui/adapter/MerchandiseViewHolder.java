package com.choi.cafe.ui.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class MerchandiseViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {
    private final T binding;

    public MerchandiseViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        this.binding = (T) DataBindingUtil.bind(itemView);
    }

    public T binding() {
        return binding;
    }
}
