/*
    Second Largest

    Difficulty: EasyAccuracy: 26.72%Submissions: 792K+Points: 2
    Given an array of positive integers arr[], return the second largest element from the array. If the second largest element doesn't exist then return -1.

    Note: The second largest element should not be equal to the largest element.

    Examples:

    Input: arr[] = [12, 35, 1, 10, 34, 1]
    Output: 34
    Explanation: The largest element of the array is 35 and the second largest element is 34.
    Input: arr[] = [10, 5, 10]
    Output: 5
    Explanation: The largest element of the array is 10 and the second largest element is 5.
    Input: arr[] = [10, 10, 10]
    Output: -1
    Explanation: The largest element of the array is 10 and the second largest element does not exist.
    Constraints:
    2 ≤ arr.size() ≤ 105
    1 ≤ arr[i] ≤ 105
* */

public class D_001_SecondLargest {
    private static int getSecondLargest(int[] arr) {
        int largest = -1;
        int sLargest = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                sLargest = largest;
                largest = arr[i];
            } else if (arr[i] > sLargest && arr[i] < largest) {
                sLargest = arr[i];
            }
        }

        return sLargest;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        System.out.println(getSecondLargest(arr));
    }
}
