package com.example.collections.ui.dashboard.first;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Dashboard2ViewModel extends ViewModel {
    private final MutableLiveData<String> mText;
    public Dashboard2ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment 2");
    }

    public LiveData<String> getText() {
        return mText;
    }
}