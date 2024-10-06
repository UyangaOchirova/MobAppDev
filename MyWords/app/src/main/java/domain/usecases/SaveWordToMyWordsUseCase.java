package domain.usecases;

import domain.models.Word;

public class SaveWordToMyWordsUseCase {
    public boolean execute(Word word){
        if (word.getName().isEmpty()){
            return false;
        }else {
            return true;
        }
    }
}