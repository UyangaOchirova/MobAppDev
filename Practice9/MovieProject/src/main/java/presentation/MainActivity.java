package presentation;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mirea.uyangaochirova.movieproject.R;

import data.repository.MovieRepositoryImpl;
import data.storage.MovieStorage;
import data.storage.sharedpref.SharedPrefMovieStorage;
import domain.models.Movie;
import domain.repository.MovieRepository;
import domain.usecases.GetFavoriteFilmUseCase;
import domain.usecases.SaveMovieToFavoriteUseCase;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "movie_prefs";
    private static final String KEY_FAVORITE_MOVIE = "favorite_movie";

    private EditText text;
    private TextView textView;
//    private MovieRepository movieRepository;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.editTextMovie);
        textView = findViewById(R.id.textViewMovie);

        MovieStorage sharedPrefMovieStorage = new SharedPrefMovieStorage(this);
        MovieRepository movieRepository = new MovieRepositoryImpl(sharedPrefMovieStorage);
//        movieRepository = new MovieRepositoryImpl(this);

        findViewById(R.id.buttonSaveMovie).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean result = new SaveMovieToFavoriteUseCase(movieRepository).execute(new Movie(2, text.getText().toString()));
                textView.setText(String.format("Save result %s", result));

                // Сохранить фильм в SharedPreferences
                saveFavoriteMovie(text.getText().toString());
            }
        });

        findViewById(R.id.buttonGetMovie).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Movie movie = new GetFavoriteFilmUseCase(movieRepository).execute();
                textView.setText(String.format("Save result %s", movie.getName()));

                // Получить фильм из SharedPreferences
                String favoriteMovie = getFavoriteMovie();
                if (favoriteMovie != null) {
                    textView.append("\nЛюбимый фильм: " + favoriteMovie);
                } else {
                    textView.append("\nУ вас нет любимого фильма");
                }
            }
        });
    }

    private void saveFavoriteMovie(String movie) {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(KEY_FAVORITE_MOVIE, movie);
        editor.apply();
    }

    private String getFavoriteMovie() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return prefs.getString(KEY_FAVORITE_MOVIE, null);
    }
}
