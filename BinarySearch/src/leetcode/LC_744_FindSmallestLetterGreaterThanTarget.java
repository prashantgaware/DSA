package leetcode;

public class LC_744_FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        char target = 'a';
        System.out.println(nextGreatestLetter(letters, target));
        target = 'c';
        System.out.println(nextGreatestLetter(letters, target));
        target = 'd';
        System.out.println(nextGreatestLetter(letters, target));
        target = 'g';
        System.out.println(nextGreatestLetter(letters, target));
    }

    /**
     * Binary Search
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * @param letters - sorted array of characters
     * @param target - target character
     * @return - smallest character in the array that is larger than the target character
     * Approach:
     * 1. Initialize low and high pointers
     * 2. While low is less than or equal to high
     * 3. Calculate mid
     * 4. If letters[mid] is less than or equal to target, move low to mid + 1
     * 5. If letters[mid] is greater than target, move high to mid - 1
     * 6. When low exceeds high, low points to the smallest letter greater than target
     * 7. Use modulo operator to handle wrap-around case
     * 8. Return letters[low % n] where n is the length of letters array
     * Dry Run:
     * Example: letters = ['c', 'f', 'j'], target = 'a'
     * 1. Initialize low = 0, high = 2
     * 2. Calculate mid = 1, letters[mid] = 'f' > 'a', move high to mid - 1 = 0
     * 3. Calculate mid = 0, letters[mid] = 'c' > 'a', move high to mid - 1 = -1
     * 4. Now low = 0, high = -1, exit loop
     * 5. Return letters[0 % 3] = 'c'
     * Example: letters = ['c', 'f', 'j'], target = 'c'
     * 1. Initialize low = 0, high = 2
     * 2. Calculate mid = 1, letters[mid] = 'f' > 'c', move high to mid - 1 = 0
     * 3. Calculate mid = 0, letters[mid] = 'c' <= 'c', move low to mid + 1 = 1
     * 4. Now low = 1, high = 0, exit loop
     * 5. Return letters[1 % 3] = 'f'
     */
    public static char nextGreatestLetter(char[] letters, int target) {
        int n = letters.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (letters[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return letters[low % n];
    }
}
