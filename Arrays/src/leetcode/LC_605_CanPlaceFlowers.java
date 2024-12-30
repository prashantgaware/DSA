package leetcode;

public class LC_605_CanPlaceFlowers {
    public boolean canPlaceFlowersOptimal(int[] flowerbed, int n) {
        int length = flowerbed.length;

        for (int i = 0; i < length && n > 0; i++) {
            if (flowerbed[i] == 0) {
                // Check if the previous and next positions are empty or out of bounds
                boolean leftEmpty = (i == 0) || (flowerbed[i - 1] == 0);
                boolean rightEmpty = (i == length - 1) || (flowerbed[i + 1] == 0);

                if (leftEmpty && rightEmpty) {
                    // Plant a flower
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }

        return n == 0;
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;
        int count = 0;

        for (int i = 0; i < length; i++) {
            if (flowerbed[i] == 0) {
                // Check if the previous and next positions are empty or out of bounds
                boolean leftEmpty = (i == 0) || (flowerbed[i - 1] == 0);
                boolean rightEmpty = (i == length - 1) || (flowerbed[i + 1] == 0);

                if (leftEmpty && rightEmpty) {
                    // Plant a flower
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }

        return count >= n;
    }

    public static void main(String[] args) {
        LC_605_CanPlaceFlowers cp = new LC_605_CanPlaceFlowers();
        int[] flowerbed = {1, 0, 0, 0, 1};
        int n = 1;
        System.out.println(cp.canPlaceFlowers(flowerbed, n));
        System.out.println(cp.canPlaceFlowersOptimal(flowerbed, n));
    }
}
