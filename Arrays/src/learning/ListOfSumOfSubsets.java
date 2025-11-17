package learning;

import java.util.ArrayList;
import java.util.List;

public class ListOfSumOfSubsets {
    public static List<Integer> subsetSums(int[] arr) {
        List<Integer> sums = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                sums.add(sum);
            }
        }
        return sums;
    }

    public static List<Integer> subsetsSumsRec(int[] arr) {
        List<Integer> sums = new ArrayList<>();
        int sum = 0;
        subsetHelper(arr, 0, sum, sums);
        return sums;
    }

    private static void subsetHelper(int[] arr, int index, int sum, List<Integer> sums) {
        if (index == arr.length) {
            sums.add(sum);
            return;
        }
        subsetHelper(arr, index+1, sum+arr[index], sums);
        subsetHelper(arr, index+1, sum, sums);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2,3};
        List<Integer> subsetSums = subsetSums(arr);
        System.out.println(subsetSums);
    }
}
