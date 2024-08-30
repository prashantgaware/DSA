package learning;

import java.util.Arrays;

public class LeftShift {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {1,2,3,4,5};
        int d = 3;
        System.out.println(Arrays.toString(leftShiftByOne(arr1)));
        System.out.println(Arrays.toString(leftShiftByD(arr2, d)));
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


        return arr;
    }
}
