package com.mirea.uyangaochirova.mireaproject;

import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class ProfileFragment extends Fragment {

    private EditText usernameEditText;
    private EditText userageEditText;
    private Button saveButton;
    private String fileName = "Profile";

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        usernameEditText = view.findViewById(R.id.name);
        userageEditText = view.findViewById(R.id.age);
        saveButton = view.findViewById(R.id.button);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProfileData();
            }
        });

        // Загрузка ранее сохраненных данных
        loadProfileData();

        return view;
    }

    private void saveProfileData() {
        String username = usernameEditText.getText().toString();
        String userage = userageEditText.getText().toString();

        // Сохранение параметров в SharedPreferences
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(fileName, Context.MODE_PRIVATE);        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.putString("userage", userage);
        editor.apply();
    }

    private void loadProfileData() {
        // Загрузка параметров из SharedPreferences
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(fileName, Context.MODE_PRIVATE);
        String savedUsername = sharedPreferences.getString("username", "");
        String savedUserage = sharedPreferences.getString("userage", "");

        // Установка ранее сохраненных данных в элементы пользовательского интерфейса
        usernameEditText.setText(savedUsername);
        usernameEditText.setText(savedUserage);
    }
}
