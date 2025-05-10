package sorting.merge;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {4,7,1,8,3,2,5,6,9,0,10};
        mergeSort(array, 0, array.length-1);
        for (int val : array)
            System.out.print(val + " ");
        System.out.println();
    }

    private static void mergeSort(int[] array, int low, int high) {

        if (low < high) {
            int mid = (low+high) / 2;
            mergeSort(array, low, mid);
            mergeSort(array, mid+1, high);
            merge(array, low, mid, high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        // size of left and right subarrays
        int n1 = mid - low + 1;
        int n2 = high - mid;

        // create temp arrays
        int[] left = new int[n1];
        int[] right = new int[n2];

        // copy data to temp arrays
        for (int i=0; i<n1; i++)
            left[i] = arr[low + i];
        // copy data to temp arrays
        for (int i=0; i<n2; i++)
            right[i] = arr[mid+i+1];

        // variables to track the current index of left, right and merged array
        // k = low is because we are merging the two arrays into arr
        // which starts from low index
        int i=0, j=0, k=low;

        // merge the temp arrays
        while (i<n1 && j<n2) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else
                arr[k++] = right[j++];
        }

        // copy remaining elements of left array
        while (i < n1)
            arr[k++] = left[i++];

        // copy remaining elements of right array
        while (j < n2)
            arr[k++] = right[j++];
    }
}
