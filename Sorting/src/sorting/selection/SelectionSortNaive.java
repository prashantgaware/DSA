package sorting.selection;

public class SelectionSortNaive {
    private static void selectionSort(int[] arr) {
        int min;
        for (int i = 0; i < arr.length-1; i++) {
            min = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 12, 11, 13, 5, 6 };
        selectionSort(arr);
        for (int i : arr)
            System.out.print(i + " ");
    }
}
