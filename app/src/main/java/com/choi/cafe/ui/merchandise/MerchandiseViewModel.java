package com.choi.cafe.ui.merchandise;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MerchandiseViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MerchandiseViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}