package data.repository;

import android.content.Context;
import android.content.SharedPreferences;
import domain.models.User;
import domain.repository.UserRepository;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class UserRepositoryImpl implements UserRepository {
    private FirebaseAuth auth;
    private SharedPreferences sharedPreferences;

    public UserRepositoryImpl(Context context) {
        auth = FirebaseAuth.getInstance();
        sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
    }

    @Override
    public void signIn(String email, String password, OnSignInCallback callback) {
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser firebaseUser = auth.getCurrentUser();
                        if (firebaseUser != null) {
                            User user = new User(firebaseUser.getUid(), firebaseUser.getEmail(), firebaseUser.getDisplayName());
                            saveUserData(user); // Сохранение данных о пользователе в SharedPreferences
                            callback.onSignIn(user);
                        } else {
                            callback.onFailure("User not found");
                        }
                    } else {
                        callback.onFailure("Authentication failed: " + task.getException().getMessage());
                    }
                });
    }

    @Override
    public User getCurrentUser() {
        FirebaseUser firebaseUser = auth.getCurrentUser();
        if (firebaseUser != null) {
            return new User(firebaseUser.getUid(), firebaseUser.getEmail(), firebaseUser.getDisplayName());
        }

        // Извлечение данных из SharedPreferences, если пользователь не найден
        return loadUserData();
    }

    @Override
    public void signOut() {
        auth.signOut();
        clearUserData(); // Очистка данных пользователя из SharedPreferences
    }

    // Метод для сохранения данных пользователя в SharedPreferences
    private void saveUserData(User user) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("user_id", user.getId());
        editor.putString("user_email", user.getEmail());
        editor.putString("user_name", user.getName()); // Если имя пользователя доступно
        editor.apply();
    }

    // Метод для загрузки данных пользователя из SharedPreferences
    private User loadUserData() {
        String userId = sharedPreferences.getString("user_id", null);
        String userEmail = sharedPreferences.getString("user_email", null);
        String userName = sharedPreferences.getString("user_name", null);

        if (userId != null && userEmail != null) {
            return new User(userId, userEmail, userName);
        }
        return null;
    }

    // Метод для очистки данных пользователя из SharedPreferences
    private void clearUserData() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
