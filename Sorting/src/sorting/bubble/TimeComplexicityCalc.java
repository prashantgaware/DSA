package sorting.bubble;

import java.time.Duration;
import java.time.LocalDateTime;

public class TimeComplexicityCalc {
    public static void main(String[] args) {
        display();
    }

    public static void display() {
        LocalDateTime start = LocalDateTime.now();
        for (int i = 0; i < 100000; i++) {
//            System.out.println();
        }
        LocalDateTime end = LocalDateTime.now();
        Duration duration = Duration.between(start, end);
        System.out.println("Time taken: " + duration.getNano());
    }
}
