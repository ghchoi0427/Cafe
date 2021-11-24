package com.choi.cafe.ui.merchandise;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.choi.cafe.R;
import com.choi.cafe.data.model.Merchandise;
import com.choi.cafe.databinding.FragmentMerchandiseBinding;
import com.choi.cafe.firebase.FireStore;
import com.choi.cafe.ui.adapter.merchandise.MerchandiseAdapter;

public class MerchandiseFragment extends Fragment {

    public MerchandiseViewModel getMerchandiseViewModel() {
        return merchandiseViewModel;
    }

    private com.choi.cafe.ui.merchandise.MerchandiseViewModel merchandiseViewModel;
    private FragmentMerchandiseBinding binding;
    FireStore fireStore;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        merchandiseViewModel = new ViewModelProvider(this).get(com.choi.cafe.ui.merchandise.MerchandiseViewModel.class);

        binding = FragmentMerchandiseBinding.inflate(inflater, container, false);

        final RecyclerView recyclerMerchandise = binding.recyclerMerchandise;
        recyclerMerchandise.setLayoutManager(new LinearLayoutManager(getContext()));
        MerchandiseAdapter merchandiseAdapter = new MerchandiseAdapter();
        recyclerMerchandise.setAdapter(merchandiseAdapter);
        setItems(recyclerMerchandise, merchandiseViewModel.getMerchandiseList());

        final Button button = binding.buttonInput;
        button.setOnClickListener(this::inputDialog);

        fireStore = new FireStore();
        fireStore.getAllData(getString(R.string.collection_merchandise), recyclerMerchandise, this);

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public static void setItems(RecyclerView recyclerView, ObservableArrayList<Merchandise> merchandiseList) {
        MerchandiseAdapter adapter;
        if (recyclerView.getAdapter() == null) {
            adapter = new MerchandiseAdapter();
            recyclerView.setAdapter(adapter);
        } else {
            adapter = (MerchandiseAdapter) recyclerView.getAdapter();
        }
        adapter.updateItems(merchandiseList);
    }

    public void inputDialog(View v) {
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_input_merchandise, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
        builder.setView(dialogView);

        final AlertDialog alertDialog = builder.create();
        alertDialog.show();

        Button buttonConfirm = dialogView.findViewById(R.id.btn_confirm);
        buttonConfirm.setOnClickListener(view -> {
            EditText editName = dialogView.findViewById(R.id.edit_name);
            EditText editNumber = dialogView.findViewById(R.id.edit_number);
            EditText editPrice = dialogView.findViewById(R.id.edit_price);

            String name = editName.getText().toString();
            String number = editNumber.getText().toString();
            String price = editPrice.getText().toString();

            Merchandise merchandise = new Merchandise(number, name, price);
            fireStore.setData("merchandise", merchandise);
            //TODO: update list

            alertDialog.dismiss();
        });
    }
}