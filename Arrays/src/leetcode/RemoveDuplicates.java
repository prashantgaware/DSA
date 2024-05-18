package leetcode;
/*
    26. Remove Duplicates from Sorted Array

    Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

    Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

    Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
    Return k.
    Custom Judge:

    The judge will test your solution with the following code:

    int[] nums = [...]; // Input array
    int[] expectedNums = [...]; // The expected answer with correct length

    int k = removeDuplicates(nums); // Calls your implementation

    assert k == expectedNums.length;
    for (int i = 0; i < k; i++) {
        assert nums[i] == expectedNums[i];
    }
    If all assertions pass, then your solution will be accepted.



    Example 1:

    Input: nums = [1,1,2]
    Output: 2, nums = [1,2,_]
    Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
    It does not matter what you leave beyond the returned k (hence they are underscores).
    Example 2:

    Input: nums = [0,0,1,1,1,2,2,3,3,4]
    Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
    Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
    It does not matter what you leave beyond the returned k (hence they are underscores).


    Constraints:

    1 <= nums.length <= 3 * 104
    -100 <= nums[i] <= 100
    nums is sorted in non-decreasing order.
 */

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k = removeDuplicatesUsingSet(nums);
        System.out.println("k = " + k);
        System.out.println("Array after removing duplicates: " + Arrays.toString(Arrays.copyOf(nums, k)));

        k = removeDuplicatesEff(nums);
        System.out.println("k = " + k);
        System.out.println("Array after removing duplicates: " );
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    private static int removeDuplicatesEff(int[] nums) {
        if (nums.length == 0)
            return 0;

        int unique = 0;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] != nums[unique]) {
                unique++;
                nums[unique] = nums[i];
            }
        }

        return unique+1;
    }

    private static int removeDuplicatesUsingSet(int[] nums) {
        Set<Integer> set = new LinkedHashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int k = set.size();
        int i = 0;
        for(int num : set) {
            nums[i++] = num;
        }

        return k;
    }
}
