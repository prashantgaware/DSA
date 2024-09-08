package searching.binary;

public class IndexOfLastOccurrence {
    public static void main(String[] args) {
        int[] nums = {1,4,5,7,7,7};
        System.out.println(indexOfLastOccurrenceRecursive(nums, 0, nums.length-1, 7));
    }

    /**
     * Using Binary Search Logic.
     * For this logic to work, we have to pass a sorted array.
     *
     * @param arr  Sorted array
     * @param low  Starting index of the search range
     * @param high Ending index of the search range
     * @param key  The element to search for
     * @return index of the last occurrence of key
     */
    private static int indexOfLastOccurrenceRecursive(int[] arr, int low, int high, int key) {
        if (low > high)
            return -1;

        int mid = (low+high) / 2;
        if (key > arr[mid])
            return indexOfLastOccurrenceRecursive(arr, mid+1, high, key);
        else if (key < arr[mid])
            return indexOfLastOccurrenceRecursive(arr, low, mid-1, key);
        else {
            // when arr[mid] is the first occurrence or arr[mid] is not equal to arr[mid-1]
            if (mid == arr.length - 1 || arr[mid] != arr[mid + 1])
                return mid;
            else
                // if not, we will go to right half.
                return indexOfLastOccurrenceRecursive(arr, mid+1, high, key);
        }
    }
}
