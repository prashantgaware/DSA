package leetcode;

public class LC_81_SearchInRotatedSortedArray2 {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,3,3,0,0,1};
        System.out.println(search(arr, 0));
        int[] arr1 = {3,1,2,3,3,3,3};
        System.out.println(search(arr1, 1));
    }

    public static boolean search(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return true;
            }

            //skipping duplicates
            if (arr[left] == arr[mid] && arr[mid] == arr[right]) {
                left++; right--;
                continue;
            }

            if (arr[left] <= arr[mid]) {
                if (target >= arr[left] && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > arr[mid] && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
