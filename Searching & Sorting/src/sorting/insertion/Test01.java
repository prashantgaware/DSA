package sorting.insertion;

public class Test01 {
    public static void main(String[] args) {
        int[] array = {9,5,2,6,8,3,8,1};
        insertionSort(array);

        for(int val : array) {
            System.out.print(val + " ");
        }
        System.out.println();
        insertionSortEfficient(array);
        for(int val : array) {
            System.out.print(val + " ");
        }
    }

    private static void insertionSort(int[] array) {
        int n = array.length;

        for (int i = 1; i<n; i++) {
            int j = i;

            while (j>0 && array[j] < array[j-1]) {
                int temp = array[j];
                array[j] = array[j-1];
                array[j-1]= temp;

                j--;
            }
        }
    }

    private static void insertionSortEfficient(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i-1;

            while (j>=0 && array[j] > key) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }
    }
}
