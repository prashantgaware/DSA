package learning;

/**
 * Problem statement:
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 * find the one that is missing from the array.
 *
 * Approach 1:
 * 1. Calculate the sum of n natural numbers using the formula n*(n+1)/2
 * 2. Calculate the sum of the elements in the array
 * 3. Subtract the sum of the elements in the array from the sum of n natural numbers
 * 4. The result will be the missing number
 */

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 8, 9, 10};
        System.out.println(missingNumber(arr));
    }

    private static int missingNumber(int[] arr) {
        int n = arr.length + 1;     // n is the size of the array and we are missing one element so we add 1
        int total = n * (n + 1) / 2;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return total - sum;
    }
}
