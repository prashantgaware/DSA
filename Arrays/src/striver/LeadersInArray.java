package striver;

import java.util.ArrayList;
import java.util.List;

/**
 * Leaders in an array are the elements that are greater than all the elements to their right side.
 * The rightmost element is always a leader.
 * For example, in the array [16, 17, 4, 3, 5, 2], the leaders are [17, 5, 2].
 */

public class LeadersInArray {
    public static List<Integer> findLeaders(int[] arr) {
        List<Integer> leaders = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            boolean leader = true;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    leader = false;
                    break;
                }
            }
            if (leader) {
                leaders.add(arr[i]);
            }
        }
        return leaders;
    }

    public static List<Integer> findLeadersOptimal(int[] arr) {
        List<Integer> leaders = new ArrayList<>();
        int maxFromRight = arr[arr.length - 1];
        leaders.add(maxFromRight);
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > maxFromRight) {
                maxFromRight = arr[i];
                leaders.add(maxFromRight);
            }
        }
        // Since we added leaders from right to left, we need to reverse the list before returning
        List<Integer> result = new ArrayList<>();
        for (int i = leaders.size() - 1; i >= 0; i--) {
            result.add(leaders.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        List<Integer> leaders = findLeaders(arr);
        System.out.println("Leaders in the array: " + leaders);
    }
}
