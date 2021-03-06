package com.skellyco.hito.domain.firebase.dao;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.skellyco.hito.core.model.entity.User;

public class UserDAO {

    public static final String TAG = "UserDAO";
    private static final String USERS_COLLECTION = "users";

    private FirebaseFirestore firestore;

    public UserDAO() {
        firestore = FirebaseFirestore.getInstance();
    }

    public CollectionReference getUsers()
    {
        return firestore.collection(USERS_COLLECTION);
    }

    public DocumentReference getUser(String uid)
    {
        return firestore.collection(USERS_COLLECTION).document(uid);
    }

    public Task<Void> createUser(User user)
    {
        return firestore.collection(USERS_COLLECTION).document(user.getUid()).set(user);
    }
}
