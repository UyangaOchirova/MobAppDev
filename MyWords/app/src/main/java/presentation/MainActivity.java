package presentation;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mirea.uyangaochirova.mywords.R;
import domain.models.Word;
import domain.usecases.GetMyWordUseCase;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textViewWord);
        findViewById(R.id.buttonGetWord).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Word wordw = new GetMyWordUseCase().execute();
                textView.setText(String.format(wordw.getName()));
            }
        });

    }
}