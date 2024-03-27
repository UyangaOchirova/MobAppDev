package com.mirea.uyangaochirova.favoritebook;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;

public class ShareActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        editText = findViewById(R.id.editText);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            TextView ageView = findViewById(R.id.textViewBook);
            String university = extras.getString(MainActivity.KEY);
            ageView.setText(String.format("Мой любимая книга: %s", university));
        }
    }

    public void sendData(View view) {
        Intent data = new Intent();
        String text = "";
        data.putExtra(MainActivity.USER_MESSAGE, text);
        setResult(Activity.RESULT_OK, data);
        finish();
    }
}