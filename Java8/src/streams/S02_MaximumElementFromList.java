package streams;

import java.util.Arrays;
import java.util.List;

public class S02_MaximumElementFromList {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2,6,3,8,5,0,5);
        list.stream()
                .mapToInt(Integer::intValue)
                .max()
                .ifPresent(max -> System.out.println("Maximum element is: " + max));

        list.stream()
                .max(Integer::compareTo)
                .ifPresent(max -> System.out.println("Maximum element using max() is: " + max));
    }
}
