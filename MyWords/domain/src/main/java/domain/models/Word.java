package domain.models;

public class Word {
    private int id;
    private String name;
    public Word(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getName() {
        return name;
    }
}

