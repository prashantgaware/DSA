package leetcode;

public class LC_32_FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] range = searchRange(arr, target);
        System.out.println("First and Last Position of " + target + ": [" + range[0] + ", " + range[1] + "]");
    }

    public static int[] searchRange(int[] arr, int target) {
        int first = findFirst(arr, target);
        int last = findLast(arr, target);
        return new int[]{first, last};
    }

    private static int findFirst(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int firstIndex = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                firstIndex = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return firstIndex;
    }
    
    private static int findLast(int[] arr, int target) {
        int left = 0; 
        int right = arr.length - 1;
        int lastIndex = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                lastIndex = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return lastIndex;
    }
}
