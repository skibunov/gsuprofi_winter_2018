package by.gsu.lesson11;

public class ILPExample {

    public static void main(String[] args) {
        int i = 1,
                j = 1,
                j1 = 1,
        j2 = 1, j3 = 1, j4 = 1, j5 = 1, j6 = 1;

        long start = System.currentTimeMillis();
        for (int k = 0; k < 1_000_000_000; k++) {
            i = i*i;
            j = j*j;
            j1 = j1*j1;
            j2 = j2*j2;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);


    }
}
