package sorting.selection;

public class Test01 {
    public static void main(String[] args) {
        int[] array = {3,2,5,8,4};
        selectionSort(array, array.length);
        for (int i=0; i< array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private static void selectionSort(int[] arr, int n) {
        for (int i=0; i <= n-2; i++) {
            int min = i;

            for (int j=i; j<=n-1; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }

            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
}
