package by.gsu.lesson3;

public class StringExample {
    public static void main(String[] args) {
        char[] arr = {'h', 'e', 'l'};
        String s = new String(arr);
        String s1 = s.substring(1);
        String s2 = "asd";
        String s3 = new String("asd");

//        System.out.println(s);
//        System.out.println(s1);
        System.out.println(s2.equals(s3));
        System.out.println(s2 == s3);

        System.out.println(s3.charAt(1));
        s2.length();
        int i = s2.compareTo("qwe");

        System.out.println(s2.toUpperCase());
        s2.compareToIgnoreCase(s1);


        String s4 = "123gh45";
        String s5 = s4.replaceAll("[0-9]{3}", " ");

        if (s5.endsWith(".jpg")) {

        }


        int x = 34;
        System.out.println(
                String.format("summ is %d qwe", x));
        System.out.println(s5);


        String str = "";
        for (int j = 0; j < 10; j++) {
            //str = str.concat(String.valueOf(j));
            str = str + j;
        }
        System.out.println(str);

        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < 10; j++) {
            builder.append(j);
//            builder.
        }
        System.out.println(builder.toString());

        String nstr = "qwe" + 1 + " qwe" + "xsxc";
    }
}
