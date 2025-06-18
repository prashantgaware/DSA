package learning;

import java.util.Arrays;

public class LeftShift {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {1,2,3,4,5};
        int[] arr3 = {1,2,3,4,5,6};
        int[] arr4 = {1,2,3,4,5,6};
        int d = 3;
        System.out.println(Arrays.toString(leftShiftByOne(arr1)));
        System.out.println(Arrays.toString(leftShiftByD(arr2, d)));
        System.out.println(Arrays.toString(leftRotateByK(arr3, d)));
        System.out.println(Arrays.toString(leftRotateUsingReversalAlgo(arr4, d)));
    }

    private static int[] leftShiftByOne(int[] arr) {
        int temp = arr[0];
        for (int i=0; i<arr.length-1; i++) {
            arr[i] = arr[i+1];
        }
        arr[arr.length - 1] = temp;

        return arr;
    }

    private static int[] leftShiftByD(int[] arr, int d) {
        for (int i=0; i<d; i++) {
            leftShiftByOne(arr);
        }

        return arr;
    }

    private static int[] leftRotateByK(int[] arr, int k) {
        int[] temp = new int[k];
        for (int i=0; i<k; i++)
            temp[i] = arr[i];
        for (int i=k; i< arr.length; i++)
            arr[i-k] = arr[i];
        for (int i=0; i<k; i++)
            arr[arr.length-k+i] = temp[i];

        return arr;
    }

    private static int[] leftRotateUsingReversalAlgo(int[] arr, int d) {

        // if d is greater than the length of the array, we can take modulo
        d = d % arr.length;

        // in first reversal, we reverse the first d elements
        // {1,2,3,4,5} -> {3,2,1,4,5}
        reverse(arr, 0, d-1);

        // in second reversal, we reverse the remaining elements
        // {3,2,1,4,5} -> {3,2,1,5,4}
        reverse(arr, d,arr.length-1);

        // in third reversal, we reverse the entire array
        // {3,2,1,5,4} -> {4,5,1,2,3}
        reverse(arr, 0, arr.length-1);

        return arr;
    }

    private static void reverse(int[] arr, int low, int high) {
        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }
}
