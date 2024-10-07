package learning;

import java.util.ArrayList;
import java.util.List;

/**
 * This class finds the intersection of two sorted arrays
 */
public class IntersectionOfTwoSortedArrays {

    /**
     * Method to find the intersection of two sorted arrays using two pointers
     * @param arr1 - first sorted array
     * @param arr2 - second sorted array
     * @return - list of common elements
     */
    private static List<Integer> findIntersectionUsingTwoPointers(int[] arr1, int[] arr2) {
        List<Integer> interSection = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else {
                if (interSection.isEmpty() || interSection.get(interSection.size() - 1) != arr1[i]) {
                    interSection.add(arr1[i]);
                }
                i++;
                j++;
            }
        }

        return interSection;
    }

    /**
     * Method to find the intersection of two sorted arrays using binary search
     * @param arr1 - first sorted array
     * @param arr2 - second sorted array
     * @return - list of common elements
     */
    private static List<Integer> findIntersectionUsingBinarySearch(int[] arr1, int[] arr2) {
        List<Integer> interSection = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            if (i == 0 || arr1[i] != arr1[i - 1]) {
                if (binarySearch(arr2, arr1[i])) {
                    interSection.add(arr1[i]);
                }
            }
        }

        return interSection;
    }

    /**
     * Method to perform binary search on a sorted array
     * @param arr - sorted array
     * @param target - element to be searched
     * @return - true if element is found, false otherwise
     */
    private static boolean binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}
