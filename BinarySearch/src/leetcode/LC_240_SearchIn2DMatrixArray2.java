package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

import static java.util.Arrays.binarySearch;

public class LC_240_SearchIn2DMatrixArray2 {
    /**
     * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
     * @param matrix - Integers in each row are sorted in ascending from left to right.
     * @param target - Integers in each column are sorted in ascending from top to bottom.
     * @return true if target is found in the matrix, or false otherwise.
     * Approach: Binary Search
     * 1. Iterate through each row of the matrix.
     * 2. For each row, perform a binary search to check if the target exists in that row.
     * 3. If the target is found in any row, return true.
     * 4. If the target is not found after checking all rows, return false.
     * Time Complexity: O(m log n) - where m is the number of rows and n is the number of columns. We perform a binary search (O(log n)) for each of the m rows.
     * Space Complexity: O(1) - We are using a constant amount of space.
     */
    public static boolean search(int[][] matrix, int target) {
        for (int[] row: matrix) {
            if (binarySearch(row, target) != -1) {
                return true;
            }
        }
        return false;
    }

    /**
     * Approach: Binary Search Optimized
     * @param matrix - Integers in each row are sorted in ascending from left to right.
     * @param target - Integers in each column are sorted in ascending from top to bottom.
     * @return true if target is found in the matrix, or false otherwise.
     * 1. Start from the top-right corner of the matrix.
     * 2. Compare the current element with the target.
     * 3. If the current element is equal to the target, return true.
     * 4. If the current element is greater than the target, move left (decrement the column index).
     * 5. If the current element is less than the target, move down (increment the row index).
     * 6. Repeat steps 2-5 until you go out of bounds of the matrix.
     * 7. If you exit the loop, return false.
     * Time Complexity: O(m + n) - In the worst case, we may need to traverse the entire row and column.
     * Space Complexity: O(1) - We are using a constant amount of space.
     */
    public static boolean search2(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;
        int col = cols - 1;
        while (row < rows && col >= 0) {
            int current = matrix[row][col];
            if (current == target) {
                return true;
            } else if (current > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] matrix = {
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };
        System.out.println(search(matrix, 5));
        System.out.println(search(matrix, 20));
        System.out.println(search2(matrix, 5));
        System.out.println(search2(matrix, 20));
    }
}
