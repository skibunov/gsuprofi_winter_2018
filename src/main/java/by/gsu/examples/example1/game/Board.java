package by.gsu.examples.example1.game;

import java.util.Objects;

public class Board extends Game {
    private int players;
    private Type type;

    public Board() {
    }

    public Board(String name, int players, Type type) {
        super(name);
        this.players = players;
        this.type = type;
    }

    public int getPlayers() {
        return players;
    }

    public void setPlayers(int players) {
        this.players = players;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Board)) return false;
        if (!super.equals(o)) return false;
        Board board = (Board) o;
        return players == board.players &&
                type == board.type;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), players, type);
    }

    @Override
    public String toString() {
        return "Board{" +
                "players=" + players +
                ", type=" + type +
                "} " + super.toString();
    }
}

