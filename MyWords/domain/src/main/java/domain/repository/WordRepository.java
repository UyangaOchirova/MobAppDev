package domain.repository;

import domain.models.Word;

public interface WordRepository {
    public boolean saveWord(Word word);
    public Word getWord();
}
