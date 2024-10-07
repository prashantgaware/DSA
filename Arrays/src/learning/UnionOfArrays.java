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
        System.out.println();
        List<Integer> unionOpt = unionOptimized(arr1,arr2,m,n);
        for (int i : unionOpt)
            System.out.print(i + "  ");
     }

    private static List<Integer> findUnion(int[] arr1, int[] arr2, int m , int n) {
        List<Integer> union = new ArrayList<>();
        int i = 0, j = 0;

        /*while (i<m && j<n) {
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
        }*/

        // Traverse both arrays using two pointers
        while (i < m && j < n) {
            if (arr1[i] < arr2[j]) {
                if (union.isEmpty() || union.get(union.size() - 1) != arr1[i]) {
                    union.add(arr1[i]);
                }
                i++;
            } else if (arr1[i] > arr2[j]) {
                if (union.isEmpty() || union.get(union.size() - 1) != arr2[j]) {
                    union.add(arr2[j]);
                }
                j++;
            } else {
                if (union.isEmpty() || union.get(union.size() - 1) != arr1[i]) {
                    union.add(arr1[i]);
                }
                i++;
                j++;
            }
        }

        while (i < m) {
            if (union.isEmpty() || union.get(union.size() - 1) != arr1[i]) {
                union.add(arr1[i]);
            }
            i++;
        }

        while (j < n) {
            if (union.isEmpty() || union.get(union.size() - 1) != arr2[j]) {
                union.add(arr2[j]);
            }
            j++;
        }

        return union;
    }

    private static List<Integer> unionOptimized(int[] arr1, int[]arr2, int n , int m) {
        ArrayList<Integer> union = new ArrayList<>();
        int i = 0, j = 0;

        // Traverse both arrays using two pointers
        while (i < n && j < m) {
            // Skip duplicate elements in arr1
            if (i > 0 && arr1[i] == arr1[i - 1]) {
                i++;
                continue;
            }

            // Skip duplicate elements in arr2
            if (j > 0 && arr2[j] == arr2[j - 1]) {
                j++;
                continue;
            }

            // Add smaller element to the union and move the pointer
            if (arr1[i] < arr2[j]) {
                union.add(arr1[i++]);
            } else if (arr1[i] > arr2[j]) {
                union.add(arr2[j++]);
            } else {
                // If elements are equal, add any one and move both pointers
                union.add(arr1[i]);
                i++;
                j++;
            }
        }

        // Add remaining elements from arr1
        while (i < n) {
            if (i == 0 || arr1[i] != arr1[i - 1]) {
                union.add(arr1[i]);
            }
            i++;
        }

        // Add remaining elements from arr2
        while (j < m) {
            if (j == 0 || arr2[j] != arr2[j - 1]) {
                union.add(arr2[j]);
            }
            j++;
        }

        return union;
    }
}
