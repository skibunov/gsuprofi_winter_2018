package by.gsu.examples.example1.game;

import java.util.Objects;

public abstract class Game implements Comparable<Game> {
    private String name;

    public Game() {
    }

    public Game(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Game o) {
        String name1 = this.getName() != null ? this.getName() : "";
        String name2 = o != null && o.getName() != null ? o.getName() : "";
        return name1.compareToIgnoreCase(name2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;
        Game game = (Game) o;
        return Objects.equals(name, game.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                '}';
    }
}
