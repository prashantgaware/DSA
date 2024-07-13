package sorting.merge;

public class MergeSort {
    public static void main(String[] args) {

        int[] array = {4,7,1,8,3};
        mergeSort(array, 0, array.length-1);
        for (int val : array)
            System.out.print(val + " ");

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
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i=0; i<n1; i++)
            left[i] = arr[low + i];

        for (int i=0; i<n2; i++)
            right[i] = arr[mid+i+1];

        int i=0, j=0, k=low;
        while (i<n1 && j<n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < n1)
            arr[k++] = left[i++];

        while (j < n2)
            arr[k++] = right[j++];
    }
}
