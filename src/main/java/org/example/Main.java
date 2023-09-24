package org.example;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern(
                "Дата: yyy-MM-dd, Час: HH:mm:ss"
        ));
        ZoneId zone = ZonedDateTime.now().getOffset();
        String zone2 = String.valueOf(ZonedDateTime.now(ZoneId.of("+1")));
        System.out.println(time);
        System.out.println(zone);
        System.out.println(zone2);
    }
}