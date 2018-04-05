package by.gsu.lesson13;

public interface DF1 {

    void run();

    default int call(int x) {
        return x + 42;
    }

    public static void main(String[] args) {
        DF1 df = () -> {};

        System.out.println(new C1().call(34));

        System.out.println(df.call(42));
    }


    interface DF2 {
        default int call(int x) {
            return x + 42;
        }
    }

    class C1 implements DF1, DF2 {


        @Override
        public void run() {

        }

        @Override
        public int call(int x) {
            return DF2.super.call(x);
        }
    }


}
