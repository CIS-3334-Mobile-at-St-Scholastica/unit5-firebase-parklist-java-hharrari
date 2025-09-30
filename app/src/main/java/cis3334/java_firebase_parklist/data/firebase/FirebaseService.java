package cis3334.java_firebase_parklist.data.firebase;

import android.util.Log;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import cis3334.java_firebase_parklist.data.model.Park;

public class FirebaseService {

    // TODO: Implement FirebaseService object
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    private void fetchParks() {
        db.collection("parks").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                for (QueryDocumentSnapshot document : task.getResult()) {
                    Log.d("FirebaseService", document.getId() + " => " + document.getData());
                    Park park = document.toObject(Park.class);
                    itemViewModel.addItem(park);
                    Log.d("CIS3334", document.getId() + " => " + document.getData());)

                }
            }else{
                Log.w("CIS3334", "Error getting documents.", task.getException());
            }
        });
    }
}