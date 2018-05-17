package by.gsu.examples.example1.game;

import by.gsu.examples.example1.Factory;
import by.gsu.examples.example1.util.NumberReader;

import java.io.PrintStream;
import java.util.Scanner;

public class GameFactory implements Factory<Game> {
    private final Scanner sc = new Scanner(System.in);
    private final PrintStream out = System.out;

    @Override
    public Game create() {
        out.println("Card(1) or Board(2) ?");
        int input = NumberReader.getWithLimit(1,2);

        Game result;
        if (input == 1) {
            result = createCard();
        } else {
            result = createBoard();
        }
        return result;
    }

    private Card createCard() {
        out.println("input name");
        String name = sc.nextLine();

        out.println("has joker?");
        Boolean hasJoker = Boolean.valueOf(sc.nextLine());

        return new Card(name, hasJoker);
    }

    private Board createBoard() {
        out.println("input name");
        String name = sc.nextLine();

        out.println("input number of players");
        int players = NumberReader.getWithLimit(1, Integer.MAX_VALUE);

        out.println(Type.getChoiceString());
        int typeNum = NumberReader.getWithLimit(1, Type.values().length);
        Type type = Type.ofNumber(typeNum);

        return new Board(name, players, type);
    }
}
