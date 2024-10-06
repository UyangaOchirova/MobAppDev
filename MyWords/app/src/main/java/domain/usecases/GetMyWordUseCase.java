package domain.usecases;

import domain.models.Word;

public class GetMyWordUseCase {
    public Word execute(){
        return new Word(3, "Apple - Яблоко");
    }
}