package data.repository;

import domain.models.Word;
import domain.repository.WordRepository;

public class WordRepositoryImpl implements WordRepository {

    @Override
    public boolean saveWord(Word word) {
        return false;
    }

    @Override
    public Word getWord(){
        return new Word(1, "Game of throne");
    }
}
