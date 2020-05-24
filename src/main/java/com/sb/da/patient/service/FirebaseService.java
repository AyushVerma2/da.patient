package com.sb.da.patient.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.sb.da.patient.entity.User;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutionException;
@Configuration
public class FirebaseService {
    public String saveuserDetail(User user) throws ExecutionException, InterruptedException {
        Firestore dbFireStore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFireStore.collection(
                "user").document(user.getFirstName()).set(user);
        return collectionsApiFuture.get().getUpdateTime().toString();


    }

    public User getUserDetails(String name) throws ExecutionException, InterruptedException {
        Firestore dbFireStore = FirestoreClient.getFirestore();

        DocumentReference documentReference =
                dbFireStore.collection("user").document(name);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();


        if (document.exists()) {
            return document.toObject(User.class);
        }
        return null;
    }

    /**
     * API
     *
     * @param name
     * @return
     */
    public String deleteUser(String name) {
        Firestore dbFireStore = FirestoreClient.getFirestore();
        dbFireStore.collection(
                "user").document(name).delete();
        return "Document with Id: " + name + " is deleted successfully";

    }


}
