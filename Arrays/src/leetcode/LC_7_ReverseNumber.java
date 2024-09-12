package leetcode;

/*
    7. Reverse Integer
    Medium
    Topics
    Companies
    Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

    Assume the environment does not allow you to store 64-bit integers (signed or unsigned).



    Example 1:

    Input: x = 123
    Output: 321
    Example 2:

    Input: x = -123
    Output: -321
    Example 3:

    Input: x = 120
    Output: 21
*/

public class LC_7_ReverseNumber {
    private static int reverse(int x) {
        int reversed = 0;

        while (x != 0) {
            int pop = x % 10;  // Get the last digit
            x /= 10;  // Remove the last digit

            // Check for overflow before multiplying and adding
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;  // Overflow case for positive numbers
            }
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;  // Overflow case for negative numbers
            }

            reversed = reversed * 10 + pop;  // Append the digit
        }

        return reversed;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
    }
}
