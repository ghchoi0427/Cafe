package com.choi.cafe.firebase;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.Executor;

public class Authentication {
    private FirebaseAuth mAuth;

    public Authentication() {
        mAuth = FirebaseAuth.getInstance();
    }

    public void signUp(String username, String password) {
        mAuth.createUserWithEmailAndPassword(username, password)
                .addOnCompleteListener((Executor) this, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("TAG", "createUserWithEmail:success");
                        FirebaseUser user = mAuth.getCurrentUser();
                        //TODO: updateUI(user);
                    } else {
                        Log.w("TAG", "createUserWithEmail:failure", task.getException());
                        //updateUI(null);
                    }
                });
    }

    public void signIn(String username, String password){
        mAuth.signInWithEmailAndPassword(username, password)
                .addOnCompleteListener((Executor) this, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("TAG", "signInWithEmail:success");
                        FirebaseUser user = mAuth.getCurrentUser();
                        //TODO:updateUI(user);
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("TAG", "signInWithEmail:failure", task.getException());
                        //updateUI(null);
                    }
                });
    }

}
