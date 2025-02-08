package sorting.selection;

public class SelectionSortOptimized {
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int min = i;
            boolean swapped = false;

            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                    swapped = true;
                }
            }

            if (swapped) {
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            } else
                break;
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        selectionSort(arr);

        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
