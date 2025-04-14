package leetcode;

public class LC_1534_CountGoodTriplets {
    public static void main(String[] args) {
        System.out.println(countGoodTriplets(new int[]{1, 2, 3, 4, 5}, 1, 2, 3));
        System.out.println(countGoodTriplets(new int[]{0, 1, 2, 2, 5}, 0, 2, 3));
        System.out.println(countGoodTripletsOptimized(new int[]{1, 1, 2, 2, 3}, 0, 0, 0));
        System.out.println(countGoodTripletsOptimized(new int[]{1, 2, 3, 4, 5}, 1, 2, 3));
    }

    /**
     * Count the number of good triplets in the array.
     * @param arr The input array of integers.
     * @param i the maximum allowed absolute difference between the first and second elements of the triplet.
     * @param j the maximum allowed absolute difference between the second and third elements of the triplet.
     * @param k the maximum allowed absolute difference between the first and third elements of the triplet.
     * @return The number of good triplets in the array.
     * Approach:
     * 1. Iterate through all possible triplets (a, b, c) in the array.
     * 2. For each triplet, check if the absolute differences between the elements satisfy the conditions:
     *   |a - b| <= i, |b - c| <= j, and |a - c| <= k.
     *   3. If all conditions are satisfied, increment the count.
     *   4. Return the count of good triplets.
     */
    private static int countGoodTriplets(int[] arr, int i, int j, int k) {
        int count = 0;
        for (int a = 0; a < arr.length; a++) {
            for (int b = a + 1; b < arr.length; b++) {
                for (int c = b + 1; c < arr.length; c++) {
                    if (Math.abs(arr[a] - arr[b]) <= i && Math.abs(arr[b] - arr[c]) <= j && Math.abs(arr[a] - arr[c]) <= k) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /**
     * Optimized version of the countGoodTriplets method.
     * This version uses a more efficient approach to count the good triplets.
     * @param arr The input array of integers.
     * @param i the maximum allowed absolute difference between the first and second elements of the triplet.
     * @param j the maximum allowed absolute difference between the second and third elements of the triplet.
     * @param k the maximum allowed absolute difference between the first and third elements of the triplet.
     * @return The number of good triplets in the array.
     * Approach:
     * 1. Iterate through all possible triplets (a, b, c) in the array.
     * 2. For each triplet, check if the absolute differences between the elements satisfy the conditions:
     *  |a - b| <= i, |b - c| <= j, and |a - c| <= k.
     *  3. If all conditions are satisfied, increment the count.
     *  4. Return the count of good triplets.
     */
    private static int countGoodTripletsOptimized(int[] arr, int i, int j, int k) {
        int count = 0;
        for (int a = 0; a < arr.length; a++) {
            for (int b = a + 1; b < arr.length; b++) {
                if (Math.abs(arr[a] - arr[b]) > i)
                    continue;
                for (int c = b + 1; c < arr.length; c++) {
                    if (Math.abs(arr[b] - arr[c]) <= j && Math.abs(arr[a] - arr[c]) <= k) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
