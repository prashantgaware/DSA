package searching.problems;

/*
* Find index of first occurrence.
* */

public class FirstOccurrence {
    public static void main(String[] args) {
        int[] array = {2,5,4,7,8,4,3,7,9,2};
        int indexNaive = firstOccurrenceNaive(array, 4);
        System.out.println("Index of First Occurrence of element is: " + indexNaive);
        int low = 0, high = array.length-1;
        int indexEff = firstOccurrenceRecursive(array, low, high, 5);
        System.out.println("Index of First Occurrence of element is: " + indexEff);
    }

    private static int firstOccurrenceRecursive(int[] array, int low, int high, int target) {
        int mid = (low+high)/2;

        if (array[mid] < target) {
            return firstOccurrenceRecursive(array, mid+1, high, target);
        } else if (array[mid] > target)
            return firstOccurrenceRecursive(array, low, mid-1, target);
        else {
            if (mid == 0 || array[mid] != array[mid-1]) {
                return mid;
            } else
                return firstOccurrenceRecursive(array, low, mid, target);
        }
    }

    private static int firstOccurrenceNaive(int[]arr, int target) {
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == target)
                return i;
        }

        return -1;
    }
}
