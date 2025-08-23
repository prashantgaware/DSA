package leetcode;

public class LC_35_SearchInInsert {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6};
        System.out.println(searchInsert(arr, 5));
        System.out.println(searchInsert(arr, 2));
        System.out.println(searchInsert(arr, 7));
        System.out.println(searchInsert(arr, 0));
    }

    /**
     * searches the index at which the target is found or the index where it can be inserted
     * @param arr given array
     * @param target given target
     * @return the index of target or the index where it can be inserted
     * Approach: Binary Search
     * 1. Initialize two pointers, low and high, to the start and end of the array.
     * 2. While low is less than or equal to high:
     *    a. Calculate the mid index.
     *    b. If the element at mid is equal to the target, return mid.
     *    c. If the element at mid is less than the target, move the low pointer to mid + 1.
     *    d. If the element at mid is greater than the target, move the high pointer to mid - 1.
     * 3. If the target is not found, return low as the insertion point.
     * Time Complexity: O(log n) - The binary search algorithm reduces the search space by half with each iteration.
     * Space Complexity: O(1) - The algorithm uses a constant amount of space.
     */
    static int searchInsert(int[] arr, int target) {
        int low = 0;
        int high = arr.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
