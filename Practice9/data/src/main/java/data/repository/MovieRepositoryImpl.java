package data.repository;

import data.storage.MovieStorage;
import domain.models.Movie;
import domain.repository.MovieRepository;
import presentation.MainActivity;

public class MovieRepositoryImpl implements MovieRepository {

    public MovieRepositoryImpl(MovieStorage sharedPrefMovieStorage) {
    }

    @Override
    public boolean saveMovie(Movie movie){
        return true;
    }
    @Override
    public Movie getMovie(){
        return new Movie(1, "Game of throne");
    }
}