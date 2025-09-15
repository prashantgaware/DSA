package streams;

import java.util.List;

public class S01_SumOfAllElementsInList {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("The sum is : " + sum);
    }
}
