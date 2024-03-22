package com.mirea.uyangaochirova.multiactivity;

import android.os.Bundle;
import androidx.annotation.NonNull;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.PersistableBundle;

public class SecondActivity extends AppCompatActivity {
    private TextView mainTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mainTextView = findViewById(R.id.textView);
        mainTextView.setText( (String) getIntent().getSerializableExtra("value"));
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}