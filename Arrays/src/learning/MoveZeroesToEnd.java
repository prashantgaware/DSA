package learning;

import java.util.Arrays;

public class MoveZeroesToEnd {

    // Method to move zeroes to the end using nested loops
    private static void moveZeroes(int[] nums) {
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // If the current element is zero
            if (nums[i] == 0) {
                // Find the next non-zero element and swap
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        swap(nums, i, j);
                        break; // Break after the first swap
                    }
                }
            }
        }
    }

    // Efficient method to move zeroes to the end
    private static void moveZeroesEff(int[] nums) {
        int count = 0; // Initialize count to track the position of non-zero elements
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // If the current element is non-zero
            if (nums[i] != 0) {
                // Swap the current element with the element at the count index
                swap(nums, i, count);
                count++; // Increment count to the next position
            }
        }
    }

    // Method to swap two elements in the array
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i]; // Store the value of the first element in a temporary variable
        nums[i] = nums[j]; // Assign the value of the second element to the first element
        nums[j] = temp; // Assign the value of the temporary variable to the second element
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 0, 4, 0, 0, 7}; // Example array with zeroes
        int[] nums1 = {1, 5, 0, 4, 2, 0, 0, 7}; // Another example array with zeroes
        moveZeroes(nums); // Call the method to move zeroes to the end
        System.out.println(Arrays.toString(nums)); // Print the modified array
        moveZeroesEff(nums1); // Call the efficient method to move zeroes to the end
        System.out.println(Arrays.toString(nums1)); // Print the modified array
    }
}
