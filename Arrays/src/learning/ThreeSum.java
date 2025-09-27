package learning;

import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> findTripletsBrute(int[] arr) {
        int n = arr.length;
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> list = Arrays.asList(arr[i], arr[j], arr[k]);
                        Collections.sort(list);
                        result.add(list);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    /**
     * Better Approach
     * @param arr - input array
     * @return list of triplets that sum to zero
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     * Approach:
     * 1. Sort the array to handle duplicates and use two-pointer technique.
     * 2. Iterate through the array with index 'first' from 0 to n-1.
     * 3. For each 'first', use a HashSet to find pairs that sum to -arr[first].
     * 4. For each 'second' index from first+1 to n-1, calculate 'third' as -arr[first] - arr[second].
     * 5. If 'third' is in the HashSet, we found a triplet (arr[first], arr[second], third).
     * 6. Add the triplet to a Set to ensure uniqueness.
     * 7. Return the list of unique triplets.
     */
    public static List<List<Integer>> findTripletsBetter(int[] arr) {
        int n = arr.length;
        Set<List<Integer>> uniqueSet = new HashSet<>();
        Arrays.sort(arr);
        for (int first = 0; first < n; first++) {
            if (first > 0 && arr[first] == arr[first - 1]) {
                continue;
            }
            Set<Integer> integerSet = new HashSet<>();
            for (int second = first + 1; second < n; second++) {
                int third = - arr[first] - arr[second];
                if (integerSet.contains(third)) {
                    List<Integer> list = Arrays.asList(arr[first], arr[second], third);
                    Collections.sort(list);
                    uniqueSet.add(list);
                }
                integerSet.add(arr[second]);
            }
        }
        return new ArrayList<>(uniqueSet);
    }

    /**
     * Optimal Approach
     * @param arr - input array
     * @return list of triplets that sum to zero
     * Time Complexity: O(n^2) + O(n log n) for sorting
     * Space Complexity: O(1) - not counting the output list
     * Approach:
     * 1. Sort the array to handle duplicates and use two-pointer technique.
     * 2. Iterate through the array with index 'i' from 0 to n-1.
     * 3. For each 'i', use two pointers 'j' and 'k' to find pairs that sum to -arr[i].
     * 4. Initialize 'j' to i+1 and 'k' to n-1.
     * 5. While j < k, calculate the sum of arr[i], arr[j], and arr[k].
     * 6. If the sum is less than zero, increment 'j' to increase the sum.
     * 7. If the sum is greater than zero, decrement 'k' to decrease the sum.
     * 8. If the sum is zero, we found a triplet (arr[i], arr[j], arr[k]).
     * 9. Add the triplet to the result list and move both pointers, skipping duplicates.
     * 10. Return the list of unique triplets.
     */
    public static List<List<Integer>> findTripletsOptimal(int[] arr) {
        int n = arr.length;;
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    ans.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    j++; k--;
                    while (j > 0 && arr[j] == arr[j -1]) {
                        j++;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4 };
        List<List<Integer>> triplets = findTripletsBrute(nums);
        System.out.println("Brute: " + triplets);
        System.out.println("Better: " + findTripletsBetter(nums));
        System.out.println("Optimal: " + findTripletsOptimal(nums));
    }
}
