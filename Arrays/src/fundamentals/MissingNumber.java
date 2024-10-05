package fundamentals;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 8, 9, 10};
        int missingNumber = findMissingNumber(arr);
        System.out.println("The missing number is: " + missingNumber);
    }

    private static int findMissingNumber(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            boolean found = false;
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[j] == i) {
                    found = true;
                    break;
                }
            }
            if (!found)
                return i;
        }

        return -1;
    }
}
