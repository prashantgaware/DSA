package learning.matrix;

public class SumOfRow {
    private static int rowSum(int[][] mat, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++ ) {
                sum += mat[i][j];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(rowSum(mat, 3));
    }
}
