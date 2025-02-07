package sorting.bubble;

public class BubbleSortNaive {
    private static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i=0; i<n; i++) {
            for (int j=0; j<n-1; j++) {
                if (arr[j] > arr[j+1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        bubbleSort(arr);

        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
