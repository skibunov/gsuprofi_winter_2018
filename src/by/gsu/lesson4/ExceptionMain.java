package by.gsu.lesson4;

public class ExceptionMain {

    public static void main(String[] args)  {
        try {
            System.out.println(calc(10));
        } catch (CustomException1 | CustomException2 e) {
            System.out.println("oops!");
        } catch (Exception e) {
            e.printStackTrace();
        }
//        catch (CustomException2 e) {
//            System.out.println("oops2!");
//        }
        finally {
            System.out.println("it's finally");
        }
    }

    public static int calc(int x)
            throws Exception {
        if (x == 0) {
            throw new CustomException1("x is zero!");
        } else if (x == 10) {
            throw new CustomException2("x is ten!");
        }
        return 10 / x;
    }

    public static int calc2(int x) {
        if (x == 0) {
            throw new RuntimeException("zero!");
        }
        return 0;
    }
}
