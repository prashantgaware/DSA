package streams;

import java.util.List;

public class S03_EvenNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenList = numbers.stream()
                                            .filter(n -> n % 2 == 0)
                                            .toList();
        System.out.println(evenList);
        List<Integer> oddList = numbers.stream()
                .filter(n -> n % 2 != 0)
                .toList();
        System.out.println(oddList);
    }
}
