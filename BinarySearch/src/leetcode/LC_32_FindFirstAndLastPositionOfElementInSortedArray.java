package leetcode;

public class LC_32_FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] range = searchRange(arr, target);
        System.out.println("First:" + range[0] + ", Last:" + range[1]);
        int[] rangeBrute = searchRangeBrute(arr, 7);
        System.out.println("First: " + rangeBrute[0] + ", Last: " + rangeBrute[1]);
    }

    /**
     * searches the range of first and last index of an element in sorted array
     * @param arr given array
     * @param target given target
     * @return the array containing the indices of first and last occurrence of element
     */
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

    /**
     *
     * @param arr
     * @param target
     * @return
     * Approach:
     * 1. Initialize two variables, first and last, to -1.
     * 2. Iterate through the array using a for loop.
     * 3. If the current element matches the target, check if first is -1
     *    (indicating the first occurrence). If so, set first to the current index.
     * 4. Regardless, update last to the current index to keep track of the last
     *    occurrence of the target.
     * 5. After the loop, return an array containing first and last.
     * Time Complexity: O(n), where n is the length of the array.
     * Space Complexity: O(1).
     */
    public static int[] searchRangeBrute(int[] arr, int target) {
        int first = -1;
        int last = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                if (first == -1) {
                    first = i;
                }
                last = i;
            }
        }

        return new int[] {first, last};
    }
}
