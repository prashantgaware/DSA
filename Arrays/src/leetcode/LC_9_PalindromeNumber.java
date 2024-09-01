package leetcode;

/*
9. Palindrome Number
Solved
Easy
Topics
Companies
Hint
Given an integer x, return true if x is a
palindrome
, and false otherwise.



Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.


Constraints:

-231 <= x <= 231 - 1
*/

public class LC_9_PalindromeNumber {
    private static boolean isPalindrome(int x) {
        int temp = x;
        int rev = 0;

        while (x > 0) {
            int digit = x % 10;
            rev = (rev*10) + digit;
            x = x/10;
        }

        if (rev == temp)
            return true;
        return false;
    }

    public static void main(String[] args) {

        // Ex. 1
        int num1 = 12345;
        System.out.println(isPalindrome(num1));;

        // Ex. 2
        int num2 = -121;
        System.out.println(isPalindrome(num2));

        // Ex.3
        int num3 = 12321;
        System.out.println(isPalindrome(num3));;
    }
}
