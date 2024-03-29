package com.example.collections.ui.dashboard.first;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Dashboard1ViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private final MutableLiveData<String> mText;

    public Dashboard1ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment 1");
    }

    public LiveData<String> getText() {
        return mText;
    }
}