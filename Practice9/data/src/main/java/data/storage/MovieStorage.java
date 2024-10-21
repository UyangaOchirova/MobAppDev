package data.storage;

import domain.models.Movie;

public interface MovieStorage {
    public data.storage.models.Movie get();
    public boolean save(Movie movie);
}
