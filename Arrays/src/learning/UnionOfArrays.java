package learning;

import java.util.ArrayList;
import java.util.List;

/*
    Union of Two Sorted Arrays
    Difficulty: MediumAccuracy: 31.39%Submissions: 317K+Points: 4
    Given two sorted arrays of size n and m respectively, find their union. The Union of two arrays can be defined as the common and distinct elements in the two arrays. Return the elements in sorted order.

    Example 1:

    Input:
    n = 5, arr1[] = {1, 2, 3, 4, 5}
    m = 5, arr2 [] = {1, 2, 3, 6, 7}
    Output:
    1 2 3 4 5 6 7
    Explanation:
    Distinct elements including both the arrays are: 1 2 3 4 5 6 7.
    Example 2:

    Input:
    n = 5, arr1[] = {2, 2, 3, 4, 5}
    m = 5, arr2[] = {1, 1, 2, 3, 4}
    Output:
    1 2 3 4 5
    Explanation:
    Distinct elements including both the arrays are: 1 2 3 4 5.
    Example 3:

    Input:
    n = 5, arr1[] = {1, 1, 1, 1, 1}
    m = 5, arr2[] = {2, 2, 2, 2, 2}
    Output:
    1 2
    Explanation:
    Distinct elements including both the arrays are: 1 2.
    Your Task:
    You do not need to read input or print anything. Complete the function findUnion() that takes two arrays arr1[], arr2[], and their size n and m as input parameters and returns a list containing the union of the two arrays.

    Expected Time Complexity: O(n+m).
    Expected Auxiliary Space: O(n+m).

    Constraints:
    1 <= n, m <= 105
    -109 <= arr1[i], arr2[i] <= 109
*/

public class UnionOfArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 1, 1, 1};
        int[] arr2 = {2, 2, 2, 2, 2};
        int m = arr1.length;
        int n = arr2.length;
        List<Integer> unionOfArrays = findUnion(arr1,arr2,m,n);
        for (int i : unionOfArrays)
            System.out.print(i + "  ");
     }

    private static List<Integer> findUnion(int[] arr1, int[] arr2, int m , int n) {
        List<Integer> union = new ArrayList<>();
        int i = 0, j = 0;

        while (i<m && j<n) {
            if (arr1[i] == arr2[j]) {
                if (union.isEmpty() || union.get(union.size())-1 != arr1[i])
                    union.add(arr1[i]);
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                if (union.isEmpty() || union.get(union.size())-1 != arr1[i]) {
                    union.add(arr1[i]);
                }
                i++;
            } else {
                if (union.isEmpty() || union.get(union.size())-1 != arr2[j]) {
                    union.add(arr2[j]);
                }
                j++;
            }

            while (i < n) {
                if (union.isEmpty() || union.get(union.size() - 1) != arr1[i]) {
                    union.add(arr1[i]);
                }
                i++;
            }

            while (j < m) {
                if (union.isEmpty() || union.get(union.size() - 1) != arr2[j]) {
                    union.add(arr2[j]);
                }
                j++;
            }
        }

        return union;
    }
}
