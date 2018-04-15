package by.gsu.examples.example1.game;

import java.util.Objects;

public class Card extends Game {
    private boolean hasJoker;

    public Card() {
    }

    public Card(String name, boolean hasJoker) {
        super(name);
        this.hasJoker = hasJoker;
    }

    public boolean isHasJoker() {
        return hasJoker;
    }

    public void setHasJoker(boolean hasJoker) {
        this.hasJoker = hasJoker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        if (!super.equals(o)) return false;
        Card card = (Card) o;
        return hasJoker == card.hasJoker;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), hasJoker);
    }

    @Override
    public String toString() {
        return "Card{" +
                "hasJoker=" + hasJoker +
                "} " + super.toString();
    }
}
