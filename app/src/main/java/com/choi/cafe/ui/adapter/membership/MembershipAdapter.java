package com.choi.cafe.ui.adapter.membership;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.choi.cafe.R;
import com.choi.cafe.data.model.Membership;
import com.choi.cafe.databinding.ItemMembershipBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MembershipAdapter extends RecyclerView.Adapter<MembershipViewHolder<ItemMembershipBinding>> {
    private ArrayList<Membership> memberships = new ArrayList<>();

    public ArrayList<Membership> getMemberships() {
        return memberships;
    }

    public void setMemberships(ArrayList<Membership> memberships) {
        this.memberships = memberships;
    }

    public void updateItems(ObservableArrayList<Membership> membershipList) {
        MembershipItemDiffCallBack callback = new MembershipItemDiffCallBack(this.memberships, membershipList);
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(callback);

        this.memberships.clear();
        this.memberships.addAll(membershipList);
        result.dispatchUpdatesTo(this);
    }

    @NonNull
    @NotNull
    @Override
    public MembershipViewHolder<ItemMembershipBinding> onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new MembershipViewHolder<>(inflater.inflate(R.layout.item_membership, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MembershipViewHolder<ItemMembershipBinding> holder, int position) {
        holder.binding().setMembership(memberships.get(position));
    }

    @Override
    public int getItemCount() {
        return memberships.size();
    }
}
