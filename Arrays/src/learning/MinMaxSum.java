package learning;

public class MinMaxSum {

    public static void main(String[] args) {
        int[] array = {2,5,3,6,3,7};
        int[] newArr = minMaxSum(array);
        for (int i : newArr)
            System.out.print(i + " ");
    }

    private static int[] minMaxSum(int[] arr) {
        int largest = getLargest(arr);
        int smallest = getSmallest(arr);
        int minSum = sum(arr) - largest;
        int maxSum = sum(arr) - smallest;

        return new int[] { maxSum, minSum };
    }

    private static int sum(int[] arr) {
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }

        return sum;
    }

    private static int getLargest(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }

        return max;
    }

    private static int getSmallest(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
        }

        return min;
    }
}
