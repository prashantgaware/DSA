package learning;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] prodArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int prod = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    prod *= nums[j];
                }
            }
            prodArr[i] = prod;
        }
        return prodArr;
    }

    /**
     * Optimized Approach
     * @param arr
     * @return
     * Approach:
     * 1. Create an answer array to store the product of elements except self.
     * 2. Traverse the input array from left to right, and for each element,
     *    store the product of all elements to the left of the current element
     *    in the answer array.
     * 3. Traverse the input array from right to left, and for each element,
     *    multiply the product of all elements to the right of the current element
     *    with the corresponding value in the answer array.
     * Time Complexity: O(n)
     * Space Complexity: O(1) (excluding the output array)
     */
    public static int[] productArrayExceptSelfOptimized(int[] arr) {
        int n = arr.length;
        int ans[] = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * arr[i - 1];
        }
        int rightProd = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = ans[i] * rightProd;
            rightProd = rightProd * arr[i];
        }
        return ans;
    }

    /**
     * Brute Force Approach
     * @param arr
     * @return
     * Approach:
     * 1. Calculate the product of all elements in the array.
     * 2. Create a result array to store the product of elements except self.
     * 3. For each element in the input array, divide the total product by that element
     *    and store the result in the corresponding index of the result array.
     * Time Complexity: O(n)
     * Space Complexity: O(1) (excluding the output array)
     * TODO: Not work for zeros in the array
     */
    public static int[] productExceptSelfBrute(int[] arr) {
        int prodOfAll = 1;
        for (int num : arr) {
            prodOfAll *= num;
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = prodOfAll / arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}
