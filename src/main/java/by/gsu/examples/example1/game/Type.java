package by.gsu.examples.example1.game;

public enum Type {

    ARCADE,
    STRATEGY;

    public static Type ofNumber(int n) {
        for (Type type : Type.values()) {
            if (type.ordinal() == n)
                return type;
        }
        throw new IllegalArgumentException("Unknown game type: " + n);
    }

    public static String getChoiceString() {
        StringBuilder sb = new StringBuilder();
        for (Type type : Type.values()) {
            sb.append(type.name())
                    .append("(")
                    .append(type.ordinal())
                    .append(") ");
        }
        return sb.toString();
    }
}
