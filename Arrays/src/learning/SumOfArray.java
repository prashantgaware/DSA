package learning;

public class SumOfArray {
    public static int sumArray(int[] arr, int index) {
        // Base case: If index is equal to the length of the array, return 0
        if (index >= arr.length) {
            return 0;
        }
        // Recursive case: Return the current element plus the sum of the rest
        return arr[index] + sumArray(arr, index + 1);
    }

    private static int sumOfArr(int[] arr) {
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int sum = sumArray(array, 0);
        int sumOfArr = sumOfArr(array);
        System.out.println("Sum of the array: " + sum); // Output: Sum of the array: 15
        System.out.println("Sum of the array: " + sumOfArr); // Output: Sum of the array: 15
    }
}
