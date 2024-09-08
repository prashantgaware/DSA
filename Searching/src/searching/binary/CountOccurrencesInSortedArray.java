package searching.binary;

public class CountOccurrencesInSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 3, 4, 5, 5, 5, 6};
        int key = 5;

        int count = countOccurrences(nums, key);
        System.out.println("Occurrences of " + key + ": " + count);
    }

    private static int countOccurrences(int[] arr, int key) {
        int first = IndexOfFirstOccurrence
                .indexOfFirstOccurrenceRecursive(arr, 0, arr.length - 1, key);

        if (first == -1)
            return 0;

        int last = IndexOfLastOccurrence.indexOfLastOccurrenceRecursive(arr, 0, arr.length - 1, key);

        return last-first+1;
    }
}
