package learning;

public class FindRotationCount {
    public static void main(String[] args) {
        int[] arr = {15, 18, 2, 3, 6, 12};
        System.out.println("Number of rotations (Brute Force): " + findRotationCountBrute(arr));
        System.out.println("Number of rotations (Optimal): " + findRotationCountOptimal(arr));
    }

    /**
     * Brute Force Approach
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @param arr - input array
     * @return number of rotations
     * Approach:
     * 1. Initialize minIdx to 0 and minValue to the first element of the array.
     * 2. Loop through the array from the second element to the second last element.
     * 3. If the current element is less than minValue, update minValue
     *    and minIdx to the current index.
     * 4. After the loop, return minIdx as the number of rotations.
     */
    public static int findRotationCountBrute(int[] arr) {
        int minIdx = 0;
        int minValue = arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
                minIdx = i;
            }
        }
        return minIdx;
    }

    /**
     * Optimal Approach
     * @param arr - input array
     * @return number of rotations
     * Approach:
     * 1. Initialize two pointers, l and h, to the start and end of
     *   the array, respectively.
     *   2. While l is less than h, do the following:
     *   3. Calculate the mid index as the average of l and h.
     *   4. If the element at mid is less than the element at h,
     *      it means the minimum element is in the left half of the array,
     *      so we update h to mid.
     *   5. Otherwise, the minimum element is in the right half of the array,
     *      so we update l to mid + 1.
     *   6. When the loop ends, l and h will converge to the index
     *      of the minimum element, which is also the number of rotations.
     *   7. Return the index of the minimum element.
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static int findRotationCountOptimal(int[] arr) {
        int l = 0;
        int h = arr.length - 1;
        while (l < h) {
            int mid = l + (h-l)/2;
            if (arr[mid] < arr[h]) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return arr[h];
    }
}
