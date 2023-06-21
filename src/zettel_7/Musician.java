package zettel_7;

import java.util.HashSet;
import java.util.Set;

public class Musician {
    private String name;
    private int performances;
    private Set<String> genres;

    public Musician(String name, int performances, Set<String> genres) {
        this.name = name;
        this.performances = performances;
        this.genres = new HashSet<>(genres); // Duplikate werden hier automatisch entfernt
    }

    public String getName() {
        return name;
    }

    public int getPerformances() {
        return performances;
    }

    public Set<String> getGenres() {
        return genres;
    }

}

