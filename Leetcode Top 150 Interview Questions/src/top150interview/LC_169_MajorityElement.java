package top150interview;

/*
    169. Majority Element
    Solved
    Easy
    Topics
    Companies
    Given an array nums of size n, return the majority element.

    The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.



    Example 1:

    Input: nums = [3,2,3]
    Output: 3
    Example 2:

    Input: nums = [2,2,1,1,1,2,2]
    Output: 2


    Constraints:

    n == nums.length
    1 <= n <= 5 * 104
    -109 <= nums[i] <= 109


    Follow-up: Could you solve the problem in linear time and in O(1) space?
*/

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_169_MajorityElement {

    private static int majorityElement (int[] arr) {
        for (int i=0; i<arr.length; i++) {
            int count = 0;

            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            if (count > (arr.length/2))
                return arr[i];
        }

        return -1;
    }

    private static int majorityElementUsingHashing( int[] list) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i : list) {
            int val = hm.getOrDefault(i, 0);
            hm.put(i, val + 1);
        }

        for (Map.Entry<Integer, Integer> it : hm.entrySet()) {
            if (it.getValue() > (list.length / 2)) {
                return it.getKey();
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,4,6,7,4,4};
        System.out.println("Majority Element: " + majorityElement(arr));
        System.out.println("Majority Element: " + majorityElementUsingHashing(arr));
    }
}
