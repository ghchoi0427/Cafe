package com.choi.cafe.ui.adapter.merchandise;

import androidx.recyclerview.widget.DiffUtil;

import com.choi.cafe.data.model.Merchandise;

import java.util.ArrayList;

public class MerchandiseItemDiffCallBack extends DiffUtil.Callback {
    private ArrayList<Merchandise> oldMerchandiseList;
    private ArrayList<Merchandise> newMerchandiseList;

    public MerchandiseItemDiffCallBack(ArrayList<Merchandise> oldMerchandiseList, ArrayList<Merchandise> newMerchandiseList) {
        this.oldMerchandiseList = oldMerchandiseList;
        this.newMerchandiseList = newMerchandiseList;
    }

    @Override
    public int getOldListSize() {
        return oldMerchandiseList.size();
    }

    @Override
    public int getNewListSize() {
        return newMerchandiseList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        Merchandise oldItem = oldMerchandiseList.get(oldItemPosition);
        Merchandise newItem = newMerchandiseList.get(newItemPosition);

        return oldItem.equals(newItem);
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        Merchandise oldItem = oldMerchandiseList.get(oldItemPosition);
        Merchandise newItem = newMerchandiseList.get(newItemPosition);

        if (!oldItem.getName().equals(newItem.getName()))
            return false;
        if (!(oldItem.getPrice().equals(newItem.getPrice())))
            return false;
        if (!oldItem.getSerialNumber().equals(newItem.getSerialNumber()))
            return false;

        return true;
    }
}
