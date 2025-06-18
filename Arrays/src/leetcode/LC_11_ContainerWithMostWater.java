package leetcode;

public class LC_11_ContainerWithMostWater {
    /**
     * Two Pointer Approach
     * @param height height of the container
     * @return maximum area of water that can be contained
     * Approach:
     * 1. Initialize two pointers, one at the beginning and one at the end of the array.
     * 2. Calculate the area formed by the lines at these two pointers.
     * 3. Move the pointer pointing to the shorter line inward, as it is the limiting factor for the area.
     * 4. Repeat until the two pointers meet.
     */
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            int width = right - left;
            maxArea = Math.max(maxArea, minHeight * width);

            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }

    /**
     * Brute force
     * @param height height of the container
     * @return maximum area of water that can be contained
     * Approach:
     * 1. Iterate through all pairs of heights.
     * 2. For each pair, calculate the area using the formula: area = min(height[i], height[j]) * (j - i).
     * 3. Keep track of the maximum area found.
     * 4. Return the maximum area.
     */
    public static int maxAreaBrute(int[] height) {
        int n = height.length;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int minHeight = Math.min(height[i], height[j]);
                int width = j - i;
                int currentMaxArea = minHeight * width;
                maxArea = Math.max(maxArea, currentMaxArea);
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println("Max Area (Two Pointer): " + maxArea(height));
        System.out.println("Max Area (Brute Force): " + maxAreaBrute(height));
    }
}
