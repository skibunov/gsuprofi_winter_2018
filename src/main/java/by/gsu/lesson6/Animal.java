package by.gsu.lesson6;

public class Animal {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @Override
    public int compareTo(Animal o) {
        return name.compareTo(o.name);
    }
}
