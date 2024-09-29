package array.search;

import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {2,4,7,2,8,5,3};
        int[] arrSorted = {1,3,5,8,8,9};
        int key = sc.nextInt();
        boolean result = linearSearch(arr, arr.length, key);
        System.out.println(result);
        boolean resultForSortedArray = linearSearchForSorted(arrSorted, arrSorted.length, key);
        System.out.println(resultForSortedArray);
    }

    /**
     *
     * @param arrSorted
     * @param length
     * @param key
     * @return
     */
    private static boolean linearSearchForSorted(int[] arrSorted, int length, int key) {
        for (int i=0; i<length; i++) {
            if (arrSorted[i] == key)
                return true;
            if (arrSorted[i] > key)
                return false;
        }

        return false;
    }

    /**
     *
     * @param arr
     * @param length
     * @param key
     * @return
     */
    private static boolean linearSearch(int[] arr, int length, int key) {
        for (int i = 0; i < length; i++) {
            if (arr[i] == key)
                return true;
        }

        return false;
    }
}
