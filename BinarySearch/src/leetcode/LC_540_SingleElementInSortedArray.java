package leetcode;

public class LC_540_SingleElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate(nums));
        System.out.println(findNonDuplicates(nums));
        System.out.println(findNonDuplicatesBrute(nums));
    }

    /**
     * Binary Search Approach
     * @param nums - sorted array where every element appears twice except for one element which appears once
     * @return - the single element that appears only once
     * Approach:
     * 1. Initialize left and right pointers
     * 2. While left is less than right
     * 3. Calculate mid
     * 4. Check if mid is even or odd
     * 5. If mid is even, check if the next element is the same
     *    - If yes, the single element is in the right half, move left to mid + 2
     *    - If no, the single element is in the left half, move right to mid
     * 6. If mid is odd, check if the previous element is the same
     *    - If yes, the single element is in the right half, move left to mid + 1
     *    - If no, the single element is in the left half, move right to mid - 1
     * 7. When left meets right, it points to the single element
     * 8. Return nums[left]
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    private static int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Check if mid is even or odd
            boolean isMidEven = (mid % 2 == 0);

            if (isMidEven) {
                // If mid is even, check if the next element is the same
                if (mid + 1 < nums.length && nums[mid] == nums[mid + 1]) {
                    // The single element is in the right half
                    left = mid + 2;
                } else {
                    // The single element is in the left half
                    right = mid;
                }
            } else {
                // If mid is odd, check if the previous element is the same
                if (mid - 1 >= 0 && nums[mid] == nums[mid - 1]) {
                    // The single element is in the right half
                    left = mid + 1;
                } else {
                    // The single element is in the left half
                    right = mid - 1;
                }
            }
        }

        // When left meets right, it points to the single element
        return nums[left];
    }

    public static int findNonDuplicates(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; // XOR operation
        }
        return result;
    }

    public static int findNonDuplicatesBrute(int[] arr) {
        for (int i = 0; i < arr.length - 1; i+=2) {
            if (arr[i] != arr[i+1]) {
                return arr[i];
            }
        }
        return arr[arr.length-1];
    }
}
