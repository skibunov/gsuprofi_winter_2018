package by.gsu.lesson5;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class DateExample {
    public static void main(String[] args) {
        Date date = new Date();
        date.setHours(3);
        System.out.println(date);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, 3);
        calendar.add(Calendar.ERA, 3);
        calendar.add(Calendar.JANUARY, 3);


        LocalDateTime now = LocalDateTime.now();
    }
}
