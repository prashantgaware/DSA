package learning;

public class MaxSubArraySum {
    /**
     *
     * @param arr
     * @return
     * Approach: Kadane's Algorithm
     * 1. Initialize maxSum to the smallest integer value and currentSum to 0
     * 2. Iterate through each element in the array
     * 3. Add the current element to currentSum
     * 4. If currentSum is greater than maxSum, update maxSum
     * 5. If currentSum becomes negative, reset it to 0
     * 6. Return maxSum
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int maxSubArraySum(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i : arr) {
            currentSum += i;
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }

    // Kadane's Algorithm
    /*
    1. Initialize two variables, maxSofar and maxEndingHere, to the first element of the array.
    2. Iterate through the array starting from the second element.
    3. For each element, update maxEndingHere to be the maximum of the current element and the sum of maxEndingHere and the current element.
    4. Update maxSofar to be the maximum of maxSofar and maxEndingHere.
    5. After iterating through the array, return maxSofar as the result.
    Time Complexity: O(n)
    Space Complexity: O(1)
    * */
    static int maxSubarraySum(int[] arr) {
        int maxSofar = arr[0];
        int maxEndingHere = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSofar = Math.max(maxSofar, maxEndingHere);
        }
        return maxSofar;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArraySum(arr));
        System.out.println(maxSubarraySum(arr));
    }
}
