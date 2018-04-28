package com.example.jahid.acm;

import android.app.Application;

import com.google.firebase.FirebaseApp;

/**
 * Created by jhasan on 3/12/17.
 */

public class ACMApplication extends Application {
    private static FirebaseApp firebaseApp;
    @Override
    public void onCreate() {
        super.onCreate();

        firebaseApp = FirebaseApp.initializeApp(this);
    }

    public static FirebaseApp getFirebaseApp() {
        return firebaseApp;
    }
}
