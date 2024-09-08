package searching.binary;

public class IndexOfFirstOccurrence {
    public static void main(String[] args) {
        int[] arr = {1,3,4,6,3,5};
        System.out.println(indexOfFirstOccurrence(arr, 5));
        int[] nums = {1,4,5,7,7,7};
        System.out.println(indexOfFirstOccurrenceRecursive(nums, 0, nums.length-1, 7));
    }

    public static int indexOfFirstOccurrence (int[] arr, int key) {
        for (int i=0; i < arr.length; i++) {
            if (arr[i] == key)
                return i;
        }

        return -1;
    }

    /**
     * Using Binary Search Logic.
     * For this logic to work, we have to pass sorted array.
     * @param arr
     * @param low
     * @param high
     * @param key
     * @return index of first occurrence of key
     */
    public static int indexOfFirstOccurrenceRecursive(int[] arr, int low, int high, int key) {
        if (low > high)
            return -1;

        int mid = (low+high) / 2;
        if (key > arr[mid])
            return indexOfFirstOccurrenceRecursive(arr, mid+1, high, key);
        else if (key < arr[mid])
            return indexOfFirstOccurrenceRecursive(arr, low, mid-1, key);
        else {
            // when arr[mid] is the first occurrence or arr[mid] is not equal to arr[mid-1]
            if (arr[mid] == 0 || arr[mid] != arr[mid-1])
                return mid;
            else
                // if not, we will go to left half.
                return indexOfFirstOccurrenceRecursive(arr, low, mid-1, key);
        }
    }
}
