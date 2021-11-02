package com.choi.cafe.firebase;

import android.util.Log;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

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
                    Log.d("TAG", "DocumentSnapshot data: " + document.getData());
                } else {
                    Log.d("TAG", "No such document");
                }
            } else {
                Log.d("TAG", "get failed with ", task.getException());
            }
        });
    }
}
