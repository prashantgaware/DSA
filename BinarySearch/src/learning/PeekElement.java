package learning;

public class PeekElement {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 1}; // Peak is 7 at index 6
        int[] arr2 = {5, 1, 2, 3, 4};        // Peaks are 5 (index 0) and 4 (index 4)
        System.out.println("Peek element index: " + findPeak(arr));
        System.out.println("Peek element index: " + findPeak(arr2));
    }

    /**
     * Find peak element in an array
     * @param arr - input array
     * @return index of peak element
     * Approach:
     * 1. Initialize two pointers, low and high, to the start and end of
     *    the array, respectively.
     * 2. While low is less than or equal to high, do the following:
     * 3. Calculate the mid index as the average of low and high.
     * 4. If the element at mid is less than the element at mid + 1,
     *    it means the peak element is in the right half of the array,
     *    so we update low to mid + 1.
     * 5. Otherwise, the peak element is in the left half of the array,
     *    so we update high to mid.
     * 6. When the loop ends, low and high will converge to the index
     *    of the peak element.
     * 7. Return the index of the peak element.
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static int findPeak(int[] arr) {
        int low = 0;
        int high = arr.length-1;
        while (low <= high) {
            int mid = low + (high-low) / 2;
            if (arr[mid] < arr[mid+1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
