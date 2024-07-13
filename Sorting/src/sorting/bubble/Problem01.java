package sorting.bubble;
/*
 * Move all 0's to end of an array.
 */

public class Problem01 {
    public static void main(String[] args) {
        int[] array = { 0,5,6,0,2};
        moveAllZerosToEnd(array);
        for(int val : array) {
            System.out.print(val + " ");
        }
    }

    // Moving all 0's to the end of an array. without disturbing their order
    private static void moveAllZerosToEnd(int[] arr) {
        int n  = arr.length;

        for (int i=0; i<n-1; i++) {
            for (int j=i; j<n-1-i; j++) {
                if (arr[j] == 0 && arr[j+1] != 0) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
