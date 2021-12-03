package com.choi.cafe.ui.membership;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.choi.cafe.R;
import com.choi.cafe.data.model.Membership;
import com.choi.cafe.databinding.DialogInputMembershipBinding;
import com.choi.cafe.databinding.FragmentMembershipBinding;
import com.choi.cafe.firebase.FireStore;
import com.choi.cafe.ui.adapter.membership.MembershipAdapter;

public class MembershipFragment extends Fragment {

    private MembershipViewModel membershipViewModel;
    private FragmentMembershipBinding fragmentMembershipBinding;
    private DialogInputMembershipBinding inputMembershipBinding;
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

        final Button buttonInput = fragmentMembershipBinding.buttonInput;
        buttonInput.setOnClickListener(view -> inputDialog(getView(), recyclerMembership));

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

    public void inputDialog(View v, RecyclerView recyclerMembership) {
        inputMembershipBinding = DialogInputMembershipBinding.inflate(getLayoutInflater(), (ViewGroup) v.getParent(), false);
        View dialogView = inputMembershipBinding.getRoot();

        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
        builder.setView(dialogView);

        final AlertDialog alertDialog = builder.create();
        alertDialog.show();

        final Button buttonConfirm = inputMembershipBinding.buttonConfirm;
        buttonConfirm.setOnClickListener(view -> {

            String membershipId = inputMembershipBinding.editMembershipId.getText().toString();
            String membershipPoint = inputMembershipBinding.editMembershipPoint.getText().toString();
            String ownerId = inputMembershipBinding.editOwnerId.getText().toString();

            Membership membership = new Membership(membershipId, membershipPoint, ownerId);
            fireStore.setData(getString(R.string.collection_membership), membership);
            //TODO: update list
            alertDialog.dismiss();
            fireStore.getAllData(getString(R.string.collection_membership), recyclerMembership, this);
        });
    }
}