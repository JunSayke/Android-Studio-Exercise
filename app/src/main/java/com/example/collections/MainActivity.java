package com.example.collections;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager2.widget.ViewPager2;

import com.example.collections.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private ViewPager2 viewPager2;
    private BottomNavigationView bottomNavigationView;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

/*        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav);

        // Get the NavController associated with the NavHostFragment
        NavController navController = navHostFragment.getNavController();

        NavigationUI.setupWithNavController(binding.bottomNavigationView, navController);*/

        ViewPager2 viewPager2 = findViewById(R.id.view_pager2);
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);

        // Set up ViewPager2 with FragmentAdapter
        MainFragmentAdapter adapter = new MainFragmentAdapter(this);
        viewPager2.setAdapter(adapter);

        // Set up Bottom Navigation View
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.homeFragment:
                    viewPager2.setCurrentItem(0, false);
                    return true;
                case R.id.dashboardFragment:
                    viewPager2.setCurrentItem(1, false);
                    return true;
                case R.id.notificationsFragment:
                    viewPager2.setCurrentItem(2, false);
                    return true;
                default:
                    return false;
            }
        });

        // Sync ViewPager2 and Bottom Navigation View
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                bottomNavigationView.setSelectedItemId(getMenuItemId(position));
            }
        });
    }

    private int getMenuItemId(int position) {
        switch (position) {
            case 0:
                return R.id.homeFragment;
            case 1:
                return R.id.dashboardFragment;
            case 2:
                return R.id.notificationsFragment;
            default:
                return -1;
        }
    }

}
