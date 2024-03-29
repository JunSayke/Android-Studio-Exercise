package com.example.collections.ui.dashboard.first;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.collections.R;
import com.example.collections.databinding.FragmentDashboard2Binding;

public class Dashboard2Fragment extends Fragment {

    private FragmentDashboard2Binding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Dashboard2ViewModel dashboard2ViewModel = new ViewModelProvider(this).get(Dashboard2ViewModel.class);

        binding = FragmentDashboard2Binding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDashboard2;
        dashboard2ViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.toDashboard1.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(requireActivity(), R.id.dashboardFragmentContainer);

            navController.navigate(R.id.action_dashboard2Fragment_to_dashboard1Fragment);
            Toast.makeText(getContext(), "Moving to Dashboard 1", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}