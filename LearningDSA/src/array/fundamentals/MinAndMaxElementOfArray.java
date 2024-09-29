package array.fundamentals;

public class MinAndMaxElementOfArray {
    public static void main(String[] args) {
        int[] arr = {1,4,7,2,7};
        int[] arrNegative = {-1,-4,-7,-2,-7};
        int max = findMax(arrNegative, arrNegative.length);
        System.out.println(max);
        int min = findMin(arr, arr.length);
        System.out.println(min);
    }

    /**
     * Function to find minimum element of an fundamentals.
     * @param arr fundamentals containing elements
     * @param length Length of fundamentals
     * @return Min element of an fundamentals
     */
    private static int findMin(int[] arr, int length) {
        int min = arr[0];
        for (int i = 1; i < length; i++) {
            if (arr[i] < min)
                min = arr[i];
        }

        return min;
    }

    /**
     * Function to find max element in an fundamentals
     * @param arr fundamentals containing elements
     * @param n Length of fundamentals
     * @return Max element of an fundamentals
     */
    private static int findMax(int[] arr, int n) {
//        int max = 0;        // if the fundamentals elements are negative, then it will print 0 as the max element
        int max = arr[0];
        for (int i = 0; i < n; i++) {
            if (max < arr[i])
                max = arr[i];
        }

        return max;
    }
}
