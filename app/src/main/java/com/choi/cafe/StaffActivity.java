package com.choi.cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.choi.cafe.ui.membership.MembershipFragment;

public class StaffActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.staff_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MembershipFragment.newInstance())
                    .commitNow();
        }
    }
}