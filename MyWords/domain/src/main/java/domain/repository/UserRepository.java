package domain.repository;

import domain.models.User;

public interface UserRepository {
    void signIn(String email, String password, OnSignInCallback callback);
    User getCurrentUser();
    void signOut();

    interface OnSignInCallback {
        void onSignIn(User user);
        void onFailure(String message);
    }
}

