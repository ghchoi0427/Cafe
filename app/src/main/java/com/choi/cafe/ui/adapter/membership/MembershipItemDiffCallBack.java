package com.choi.cafe.ui.adapter.membership;

import androidx.recyclerview.widget.DiffUtil;

import com.choi.cafe.data.model.Membership;

import java.util.ArrayList;

public class MembershipItemDiffCallBack extends DiffUtil.Callback {
    private ArrayList<Membership> oldMembershipList;
    private ArrayList<Membership> newMembershipList;

    public MembershipItemDiffCallBack(ArrayList<Membership> oldMembershipList, ArrayList<Membership> newMembershipList) {
        this.oldMembershipList = oldMembershipList;
        this.newMembershipList = newMembershipList;
    }

    @Override
    public int getOldListSize() {
        return oldMembershipList.size();
    }

    @Override
    public int getNewListSize() {
        return newMembershipList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        Membership oldItem = oldMembershipList.get(oldItemPosition);
        Membership newItem = newMembershipList.get(newItemPosition);

        return oldItem.equals(newItem);
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        Membership oldItem = oldMembershipList.get(oldItemPosition);
        Membership newItem = newMembershipList.get(newItemPosition);

        if (!oldItem.getMembershipID().equals(newItem.getMembershipID()))
            return false;
        if (!(oldItem.getMembershipPoint().equals(newItem.getMembershipPoint())))
            return false;
        if (!oldItem.getOwner().equals(newItem.getOwner()))
            return false;

        return true;
    }
}
