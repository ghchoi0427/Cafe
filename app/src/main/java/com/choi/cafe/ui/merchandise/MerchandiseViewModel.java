package com.choi.cafe.ui.merchandise;

import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.choi.cafe.data.model.Merchandise;

public class MerchandiseViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private ObservableArrayList<Merchandise> merchandises;

    public MerchandiseViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
        merchandises = new ObservableArrayList<>();
        setMerchandiseList(merchandises);
    }

    public void addItem(Merchandise merchandise) {
        merchandises.add(merchandise);
        //TODO: call this method for adding item to recyclerview
    }

    public ObservableArrayList<Merchandise> getMerchandiseList() {
        return merchandises;
    }

    public void setMerchandiseList(ObservableArrayList<Merchandise> merchandises) {
        this.merchandises = merchandises;
    }

    public LiveData<String> getText() {
        return mText;
    }
}
