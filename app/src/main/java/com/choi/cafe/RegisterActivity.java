package com.choi.cafe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.choi.cafe.data.model.Customer;
import com.choi.cafe.data.model.Staff;
import com.choi.cafe.databinding.ActivityRegisterBinding;
import com.choi.cafe.firebase.FireStore;

public class RegisterActivity extends AppCompatActivity {
    ActivityRegisterBinding binding;
    FireStore fireStore = new FireStore();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String userType = getIntent().getExtras().getString("userType");
        final Button btnRegister = binding.buttonRegister;

        if (userType.equals("staff")) {
            binding.textRegisterTelNumber.setVisibility(View.INVISIBLE);
            binding.editRegisterTelNumber.setVisibility(View.INVISIBLE);

            btnRegister.setOnClickListener(view -> {
                Staff staff = new Staff(binding.editRegisterSerialNumber.getText().toString(),
                        binding.editRegisterName.getText().toString(),
                        binding.editRegisterSex.getText().toString(),
                        binding.editRegisterAge.getText().toString(),
                        binding.editRegisterPosition.getText().toString());
                new FireStore().setData("staff", staff);
                finish();
            });
        }
        if (userType.equals("customer")) {
            binding.textRegisterAge.setVisibility(View.GONE);
            binding.textRegisterSex.setVisibility(View.GONE);
            binding.textRegisterPosition.setVisibility(View.GONE);
            binding.editRegisterAge.setVisibility(View.GONE);
            binding.editRegisterSex.setVisibility(View.GONE);
            binding.editRegisterPosition.setVisibility(View.GONE);

            btnRegister.setOnClickListener(view -> {
                String serialNumber = binding.editRegisterSerialNumber.getText().toString();
                String name = binding.editRegisterName.getText().toString();
                String telNo = binding.editRegisterTelNumber.getText().toString();

                Customer customer = new Customer(serialNumber, name, telNo);
                fireStore.setData("customer", customer);
                finish();
            });
        }
    }
}