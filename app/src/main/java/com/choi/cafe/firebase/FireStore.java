package com.choi.cafe.firebase;

import android.util.Log;

import androidx.databinding.ObservableArrayList;
import androidx.recyclerview.widget.RecyclerView;

import com.choi.cafe.data.model.Membership;
import com.choi.cafe.data.model.Merchandise;
import com.choi.cafe.ui.membership.MembershipFragment;
import com.choi.cafe.ui.merchandise.MerchandiseFragment;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.Objects;

public class FireStore {
    FirebaseFirestore db;

    public FireStore() {
        db = FirebaseFirestore.getInstance();
    }

    public void getData(String collectionPath, String documentPath) {
        DocumentReference docRef = db.collection(collectionPath).document(documentPath);
        docRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();
                assert document != null;
                if (document.exists()) {
                    //TODO: update ui
                } else {
                    Log.d("TAG", "No such document");
                }
            } else {
                Log.d("TAG", "get failed with ", task.getException());
            }
        });
    }

    public void getAllData(String collectionPath, RecyclerView recyclerView, Object object) {
        //TODO: generify this method
        if (object.getClass().equals(MerchandiseFragment.class)) {
            db.collection(collectionPath)
                    .get()
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            ObservableArrayList<Merchandise> list = new ObservableArrayList<>();
                            for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                                Merchandise merchandise = document.toObject(Merchandise.class);
                                list.add(merchandise);
                            }
                            MerchandiseFragment.setItems(recyclerView, list);
                        } else {
                            Log.d("tester", "Error getting documents: ", task.getException());
                        }
                    });

        }
        if (object.getClass().equals(MembershipFragment.class)) {
            db.collection(collectionPath)
                    .get()
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            ObservableArrayList<Membership> list = new ObservableArrayList<>();
                            for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                                Membership membership = document.toObject(Membership.class);
                                list.add(membership);
                            }
                            MembershipFragment.setItems(recyclerView, list);
                        } else {
                            Log.d("tester", "Error getting documents: ", task.getException());
                        }
                    });
        }
    }

}
