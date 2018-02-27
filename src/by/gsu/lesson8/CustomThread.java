package by.gsu.lesson8;

import static by.gsu.lesson8.ThreadExamples.sleep2;

public class CustomThread implements Runnable {

    private String someName;

    public CustomThread(String someName) {
        this.someName = someName;
    }

    @Override
    public void run() {
        sleep2(2000);
        System.out.println(someName);

    }
}
