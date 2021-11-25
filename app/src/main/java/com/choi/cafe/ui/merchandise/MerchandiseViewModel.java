package com.choi.cafe.ui.merchandise;

import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.ViewModel;

import com.choi.cafe.data.model.Merchandise;
import com.choi.cafe.firebase.FireStore;

public class MerchandiseViewModel extends ViewModel {

    private ObservableArrayList<Merchandise> merchandises;
    private FireStore fireStore;

    public MerchandiseViewModel() {
        merchandises = new ObservableArrayList<>();
        setMerchandiseList(merchandises);
        fireStore = new FireStore();
    }

    public void addItem(Merchandise merchandise) {
        merchandises.add(merchandise);
        //TODO: call this method for adding item to recyclerview
    }

    public void sendQuery(String collection, Merchandise merchandise) {
        fireStore.setData(collection, merchandise);
    }

    public ObservableArrayList<Merchandise> getMerchandiseList() {
        return merchandises;
    }

    public void setMerchandiseList(ObservableArrayList<Merchandise> merchandises) {
        this.merchandises = merchandises;
    }

}
