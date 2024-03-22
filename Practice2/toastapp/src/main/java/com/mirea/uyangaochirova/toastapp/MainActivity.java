package com.mirea.uyangaochirova.toastapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.appcompat.app.AppCompatActivity;


import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void ViewToast(View v){
        EditText editText1 = findViewById(R.id.editTextText1);
        String text = "СТУДЕНТ № 18 ГРУППА БСБО-10-21 Количество символов - "
                + editText1.getText().length();
        Toast toast = Toast.makeText(getApplicationContext(),
                text,
                Toast.LENGTH_SHORT);
        toast.show();
    }
}