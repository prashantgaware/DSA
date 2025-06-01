package learning;

public class FirstAndLastPositionOfElementInSortedArray {
    // time complexity: O(n)
    // space complexity: O(1)
    public static int[] firstAndLastPositionBrute(int[] nums, int target) {
        int first = -1;
        int last = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                // we find the first occurrence
                // we are using -1 as a flag to indicate that we haven't found the first occurrence yet
                // if we find the first occurrence, we set first to the current index
                if (first == -1) {
                    first = i;
                }
                last = i;
            }
        }

        return new int[] {first, last};
    }

    // time complexity: O(log n)
    // space complexity: O(1)
    public static int[] findFirstAndLastUsingBinarySearch(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        return new int[] {first, last};
    }

    private static int findFirst(int[] nums, int target) {
        int firstOccurrence = -1;
        int low = 0;
        int high = nums.length-1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                firstOccurrence = mid;
                high = high - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return firstOccurrence;
    }

    private static int findLast(int[] nums, int target) {
        int lastOccurrence = -1;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                lastOccurrence = mid;
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return lastOccurrence;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] positionsBrute = firstAndLastPositionBrute(nums, target);
        System.out.println("First Position: " + positionsBrute[0] + ", Last Position: " + positionsBrute[1]);
        int[] positionsOptimal = findFirstAndLastUsingBinarySearch(nums, 7);
        System.out.println("First Position: " + positionsOptimal[0] + ", Last Position: " + positionsOptimal[1]);
    }
}
