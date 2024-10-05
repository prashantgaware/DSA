package searching.binary;

/**
 * Binary Search Modified : This is a modified version of binary search where we are searching for an element in a
 * sorted array. If the element is found, it returns true, otherwise false.
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 * Stable: Yes
 * In-Place: Yes
 * Given in Horrowitz-Sahni book.
 */
public class BinarySearchModified {
    private static boolean bSearchModified(int[] array, int n, int target) {
        int low = 1, high = n+1;
        while (low < high-1) {
            int mid = low + (high-low) / 2;
            if (target < array[mid])
                high = mid;
            else
                low = mid;
        }

        if (target == array[low])
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 8, 9, 10};
        int n = array.length;
        // TODO : when we are providing last index of array, throwing ArrayIndexOutOfBoundsException
        int target = 8;
        boolean found = bSearchModified(array, n, target);
        if (found)
            System.out.println("Element found");
        else
            System.out.println("Element not found");
    }
}
