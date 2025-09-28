package learning;

public class SearchInRotatedSortedArray {
    /**
     * Search in a rotated sorted array
     * @param arr - rotated sorted array
     * @param target - target value to search
     * @return index of target if found, otherwise -1
     * Approach:
     * 1. Initialize two pointers, left and right, to the start and end of
     *   the array.
     * 2. While left is less than or equal to right, calculate the mid index.
     * 3. If the middle element is the target, return the mid index.
     * 4. Determine which half of the array is sorted.
     * 5. If the left half is sorted, check if the target lies within this
     *   half. If it does, adjust the right pointer to mid - 1. Otherwise,
     *   adjust the left pointer to mid + 1.
     * 6. If the right half is sorted, check if the target lies within this
     *   half. If it does, adjust the left pointer to mid + 1. Otherwise,
     *   adjust the right pointer to mid - 1.
     * 7. If the target is not found, return -1.
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    private static int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            // Check if the left half is sorted
            if (arr[left] <= arr[mid]) {
                if (arr[left] <= target && target < arr[mid]) {
                    right = mid - 1; // Target is in the left half
                } else {
                    left = mid + 1; // Target is in the right half
                }
            } else { // Right half is sorted
                if (arr[mid] < target && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(search(arr, target)); // Output: 4
    }
}
