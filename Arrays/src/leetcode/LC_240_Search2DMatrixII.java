package leetcode;

import java.util.Arrays;

public class LC_240_Search2DMatrixII {
    /**
     * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
     * @param matrix 2D matrix
     * @param target target to search for
     * @return true if target is found, false otherwise
     * Approach: Binary Search on each row
     * 1. Iterate through each row of the matrix.
     * 2. For each row, perform a binary search to find the target.
     * 3. If the target is found in any row, return true.
     * 4. If the target is not found in any row, return false.
     * Time Complexity: O(m * log n) where m is the number of rows and n is the number of columns.
     * Space Complexity: O(1) since we are not using any additional data structures.
     */
    public static boolean search2dMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        for (int[] rows : matrix) {
            if (Arrays.binarySearch(rows, target) > 0) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param matrix
     * @param target
     * @return
     * Approach: Start from the top-right corner of the matrix and eliminate rows or columns based on comparisons.
     * 1. Initialize row to 0 and col to the last column index.
     * 2. While row is within bounds and col is within bounds:
     *    a. If the current element is equal to the target, return true.
     *    b. If the current element is greater than the target, move left (decrement col).
     *    c. If the current element is less than the target, move down (increment row).
     * 3. If the target is not found, return false.
     * Time Complexity: O(m + n) where m is the number of rows and n is the number of columns.
     * Space Complexity: O(1) since we are not using any additional data structures.
     */
    public static boolean search2dMatrixBinarySearch(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0;
        int col = cols - 1;
        while (row < rows && col >= 0) {
            int curr_element = matrix[row][col];
            if (curr_element == target) {
                return true;
            } else if (curr_element > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 5;
        System.out.println("Is target present: " + search2dMatrix(matrix, target));
        System.out.println("Is target present (Binary Search): " + search2dMatrixBinarySearch(matrix, 23));
    }
}
