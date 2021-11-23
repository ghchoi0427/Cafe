package com.choi.cafe.ui.merchandise;

import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.ViewModel;

import com.choi.cafe.data.model.Merchandise;

public class MerchandiseViewModel extends ViewModel {

    private ObservableArrayList<Merchandise> merchandises;

    public MerchandiseViewModel() {
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

}
