package leetcode;
/*
    189. Rotate Array
    Solved
    Medium
    Topics
    Companies
    Hint
    Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.



    Example 1:

    Input: nums = [1,2,3,4,5,6,7], k = 3
    Output: [5,6,7,1,2,3,4]
    Explanation:
    rotate 1 steps to the right: [7,1,2,3,4,5,6]
    rotate 2 steps to the right: [6,7,1,2,3,4,5]
    rotate 3 steps to the right: [5,6,7,1,2,3,4]
    Example 2:

    Input: nums = [-1,-100,3,99], k = 2
    Output: [3,99,-1,-100]
    Explanation:
    rotate 1 steps to the right: [99,-1,-100,3]
    rotate 2 steps to the right: [3,99,-1,-100]


    Constraints:

    1 <= nums.length <= 105
    -231 <= nums[i] <= 231 - 1
    0 <= k <= 105


    Follow up:

    Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
    Could you do it in-place with O(1) extra space?
*/
public class LC_189_LeftRotateByD {
    private static void leftRotateByD(int[] arr, int d) {
        int[] temp = new int[d];
        for (int i=0; i<d; i++)
            temp[i] = arr[i];

        for (int i=d; i< arr.length; i++)
            arr[i - d] = arr[i];

        for (int i=0; i<d; i++)
            arr[arr.length-d+i] = temp[i];

    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int d = 3;
        leftRotateByD(arr, d);

        for (int i : arr)
            System.out.print(i + "  ");
        System.out.println();
        int[] arr1 = {6,5,4,3,2,1};
        rotate(arr1, d);
        for (int i : arr1)
            System.out.print(i + "  ");
        System.out.println();
    }
}
