package com.choi.cafe.ui.membership;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.choi.cafe.databinding.FragmentMembershipBinding;

public class MembershipFragment extends Fragment {

    private MembershipViewModel membershipViewModel;
    private FragmentMembershipBinding fragmentMembershipBinding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        membershipViewModel =
                new ViewModelProvider(this).get(MembershipViewModel.class);

        fragmentMembershipBinding = FragmentMembershipBinding.inflate(inflater, container, false);
        View root = fragmentMembershipBinding.getRoot();

        final TextView textView = fragmentMembershipBinding.textMembership;
        membershipViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentMembershipBinding = null;
    }
}