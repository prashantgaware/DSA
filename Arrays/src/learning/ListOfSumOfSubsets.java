package learning;

import java.util.ArrayList;
import java.util.List;

public class ListOfSumOfSubsets {
    /**
     * Gives all subset sums of the given array
     * @param arr input array
     * @return list of subset sums
     * Approach:
     * 1. Initialize an empty list to store the subset sums.
     * 2. Use two nested loops to generate all possible subsets of the array.
     *    - The outer loop iterates through each element of the array.
     *    - The inner loop calculates the sum of subsets starting from the current
     *      element of the outer loop to the end of the array.
     * 3. For each subset, add the sum to the list of subset sums.
     * 4. Return the list of subset sums.
     * Time Complexity: O(n^2), where n is the number of elements in the array.
     * Space Complexity: O(k), where k is the number of subset sums generated.
     */
    public static List<Integer> subsetSums(int[] arr) {
        List<Integer> sums = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                sums.add(sum);
            }
        }
        return sums;
    }

    /**
     * Gives all subset sums of the given array using recursion
     * @param arr input array
     * @return list of subset sums
     * Approach:
     * 1. Initialize an empty list to store the subset sums.
     * 2. Use a helper function to recursively generate all possible subsets of the array.
     *    - The helper function takes the current index, current sum, and the list of sums as parameters.
     *    - If the current index is equal to the length of the array, add the current sum to the list of sums.
     *    - Otherwise, recursively call the helper function twice:
     *      a. Once including the current element in the sum.
     *      b. Once excluding the current element from the sum.
     * 3. Return the list of subset sums.
     * Time Complexity: O(2^n), where n is the number of elements in the array.
     * Space Complexity: O(k), where k is the number of subset sums generated.
     */
    public static List<Integer> subsetsSumsRec(int[] arr) {
        List<Integer> sums = new ArrayList<>();
        int sum = 0;
        subsetHelper(arr, 0, sum, sums);
        return sums;
    }

    private static void subsetHelper(int[] arr, int index, int sum, List<Integer> sums) {
        if (index == arr.length) {
            sums.add(sum);
            return;
        }
        subsetHelper(arr, index+1, sum+arr[index], sums);
        subsetHelper(arr, index+1, sum, sums);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2,3};
        List<Integer> subsetSums = subsetSums(arr);
        System.out.println(subsetSums);
    }
}
