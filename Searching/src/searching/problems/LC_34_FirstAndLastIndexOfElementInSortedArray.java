package searching.problems;

import java.util.Arrays;

public class LC_34_FirstAndLastIndexOfElementInSortedArray {

    public static void main(String[] args) {
        int[] arr = {0,4,4,4,4,4,4,4};
        int[] res = searchRange(arr, 4);
        System.out.println(Arrays.toString(res));
    }

    static int[] searchRange(int[] arr, int target) {
        int left_most = findLeftMost(arr, target);
        int right_most = findRightMost(arr, target);

        return new int[] {left_most, right_most};
    }

    private static int findRightMost(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;

        int right_most = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                right_most = mid;
                l = mid+1;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return right_most;
    }

    private static int findLeftMost(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;

        int left_most = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                left_most = mid;
                r = mid-1;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return left_most;
    }

}
