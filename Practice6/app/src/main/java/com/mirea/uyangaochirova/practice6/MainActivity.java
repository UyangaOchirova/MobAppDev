package com.mirea.uyangaochirova.practice6;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText numberGroup;
    EditText numberInGroup;
    EditText favouriteMovie;
    String  GROUP = "Группа";
    String  NUMBER = "Номер по списку";
    String  MOVIE = "Любимый фильм";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberGroup = findViewById(R.id.numberGroup);
        numberInGroup = findViewById(R.id.numberInGroup);
        favouriteMovie = findViewById(R.id.favoriteMovie);

        SharedPreferences sharedPref = getSharedPreferences("mirea_settings", Context.MODE_PRIVATE);
        numberGroup.setText(sharedPref.getString(GROUP, ""));
        numberInGroup.setText(sharedPref.getString(NUMBER, ""));
        favouriteMovie.setText(sharedPref.getString(MOVIE, ""));
    }

    public void onClickButton(View view){
        SharedPreferences	sharedPref	= getSharedPreferences("mirea_settings",	Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(GROUP, numberGroup.getText().toString());
        editor.putString(NUMBER, numberInGroup.getText().toString());
        editor.putString(MOVIE, favouriteMovie.getText().toString());
        editor.apply();
    }
}
