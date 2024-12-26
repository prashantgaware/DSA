package searching.problems;

import java.util.Arrays;

public class LC_153_FindMinInRotatedSortedArray {
    static int findMin(int[] arr) {
        int l = 0, r = arr.length-1;
        while (l < r) {
            int mid = l + (r-l) / 2;
            if (arr[mid] > arr[r])
                l = mid+1;
            else
                r = mid;
        }

        return arr[r];
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(findMin(arr));

        // OR we could use the sort() method
        int[] arr1 = {4,5,6,7,1,2};
         Arrays.sort(arr1);
        System.out.println(arr1[0]);
    }
}
