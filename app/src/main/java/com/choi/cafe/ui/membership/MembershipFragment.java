package com.choi.cafe.ui.membership;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.choi.cafe.R;
import com.choi.cafe.data.model.Membership;
import com.choi.cafe.databinding.FragmentMembershipBinding;
import com.choi.cafe.firebase.FireStore;
import com.choi.cafe.ui.adapter.membership.MembershipAdapter;

public class MembershipFragment extends Fragment {

    private MembershipViewModel membershipViewModel;
    private FragmentMembershipBinding fragmentMembershipBinding;
    FireStore fireStore;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        membershipViewModel =
                new ViewModelProvider(this).get(MembershipViewModel.class);

        fragmentMembershipBinding = FragmentMembershipBinding.inflate(inflater, container, false);
        View root = fragmentMembershipBinding.getRoot();

        final RecyclerView recyclerMembership = fragmentMembershipBinding.recyclerMembership;
        recyclerMembership.setLayoutManager(new LinearLayoutManager(getContext()));
        MembershipAdapter membershipAdapter = new MembershipAdapter();
        recyclerMembership.setAdapter(membershipAdapter);
        setItems(recyclerMembership, membershipViewModel.getMembershipList());

        fireStore = new FireStore();
        fireStore.getAllData(getString(R.string.collection_membership), recyclerMembership, this);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentMembershipBinding = null;
    }

    public static void setItems(RecyclerView recyclerView, ObservableArrayList<Membership> membershipList) {
        MembershipAdapter adapter;
        if (recyclerView.getAdapter() == null) {
            adapter = new MembershipAdapter();
            recyclerView.setAdapter(adapter);
        } else {
            adapter = (MembershipAdapter) recyclerView.getAdapter();
        }
        adapter.updateItems(membershipList);
    }
}