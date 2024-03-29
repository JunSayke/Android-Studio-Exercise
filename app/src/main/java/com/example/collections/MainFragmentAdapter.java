package com.example.collections;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.collections.ui.dashboard.DashboardFragment;
import com.example.collections.ui.home.HomeFragment;
import com.example.collections.ui.notifications.NotificationsFragment;

public class MainFragmentAdapter extends FragmentStateAdapter {
    public MainFragmentAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @Override
    public int getItemCount() {
        return 3; // Total number of fragments
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new DashboardFragment();
            case 2:
                return new NotificationsFragment();
            default:
                return new HomeFragment();
        }
    }
}

