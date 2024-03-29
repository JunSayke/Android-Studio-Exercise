package com.example.collections.ui.dashboard.first;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.collections.R;
import com.example.collections.databinding.FragmentDashboard1Binding;
import com.example.collections.ui.dashboard.DashboardFragment;
import com.example.collections.ui.notifications.NotificationsViewModel;

public class Dashboard1Fragment extends Fragment {
    private FragmentDashboard1Binding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Dashboard1ViewModel dashboard1ViewModel =
                new ViewModelProvider(this).get(Dashboard1ViewModel.class);

        binding = FragmentDashboard1Binding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDashboard1;
        dashboard1ViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.toDashboard2.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(requireActivity(), R.id.dashboardFragmentContainer);

            navController.navigate(R.id.action_dashboard1Fragment_to_dashboard2Fragment);
            Toast.makeText(getContext(), "Moving to Dashboard 2", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}