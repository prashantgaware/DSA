package leetcode;

public class LC_1_TwoSum_Brute {
    public static int[] twoSumBrute(int[] array, int target) {
        int n = array.length;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (array[i] + array[j] == target){
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] array = {2, 17, 7, 15};
        int target = 9;
        int[] result = twoSumBrute(array, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}
