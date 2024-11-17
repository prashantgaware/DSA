package fundamentals;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 8, 9, 10};
        int missingNumber = findMissingNumber(arr);
        System.out.println("The missing number is: " + missingNumber);
        int missingNumberUsingSum = findMissingNumberUsingSum(arr);
        System.out.println("The missing number using sum is: " + missingNumberUsingSum);
    }

    private static int findMissingNumber(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            boolean found = false;
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[j] == i) {
                    found = true;
                    break;
                }
            }
            if (!found)
                return i;
        }

        return -1;
    }

    /**
     * This method finds the missing number in an array of n-1 elements
     * @param arr array of n-1 elements
     * @return missing number
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    private static int findMissingNumberUsingSum(int[] arr) {
        int n = arr.length + 1;
        int sum = n * (n + 1) / 2;
        for (int i = 0; i < arr.length; i++) {
            sum = sum - arr[i];
        }
        return sum;
    }
}
