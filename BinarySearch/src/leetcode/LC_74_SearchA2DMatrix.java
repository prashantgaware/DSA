package leetcode;

public class LC_74_SearchA2DMatrix {

    /**
     * Searches for a target value in a 2D matrix
     * @param matrix given 2D matrix
     * @param target target to search for
     * @return true if target is found, false otherwise
     * Approach: Treat the 2D matrix as a 1D sorted array and apply binary search.
     * Time Complexity: O(log(m * n)) where m is the number of rows and n is the number of columns.
     * Space Complexity: O(1) since we are not using any additional data structures.
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / cols][mid % cols];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    /**
     * Brute force search for target in 2D matrix
     * @param matrix given 2D matrix
     * @param target target to search for
     * @return true if target is found, false otherwise
     * Approach: Iterate through each element in the matrix
     * and check if it matches the target.
     * Time Complexity: O(m * n) where m is the number of rows and n is the number of columns.
     * Space Complexity: O(1) since we are not using any additional data structures.
     */
    public static boolean searchMatrixBrute(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        for (int[] row : matrix) {
            for (int num : row) {
                if (num == target) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target = 3;

        boolean foundBinary = searchMatrix(matrix, target);
        System.out.println("Found using binary search: " + foundBinary);

        boolean foundBrute = searchMatrixBrute(matrix, target);
        System.out.println("Found using brute force: " + foundBrute);
    }
}
