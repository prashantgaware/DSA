public class D_004_RotateArray {
    private static void rotateArr(int[] arr, int d) {
        int n = arr.length;
        d = d % n;

        reverseArr(arr, 0, d-1);
        reverseArr(arr, d, n-1);
        reverseArr(arr, 0, n-1);
    }

    private static void reverseArr(int[] arr, int start, int end) {
        if (arr == null || arr.length == 1)
            return;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int d = 2;
        rotateArr(arr, d);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
