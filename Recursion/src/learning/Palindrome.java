package learning;

public class Palindrome {
    public static void main(String[] args) {
        String s = "abcbaa";
        System.out.println(isPalindromeUsingRec(s, 0, s.length()-1));
    }

    // Approach 1: Using Recursion
    // 1. If the string is empty or has only one character, then it is a palindrome.
    // 2. If the first and last characters are same, then check for the remaining string.
    // 3. If the first and last characters are not same, then it is not a palindrome.
    // Time Complexity: O(n)
    private static boolean isPalindromeUsingRec(String s, int start, int end) {
        if (start >= end) {
            return true;
        }

        // here we are comparing the first and last characters of the string
        // and then calling the function recursively with the remaining string
        // by increasing the start index and decreasing the end index
        return (s.charAt(start) == s.charAt(end)
                && isPalindromeUsingRec(s, start+1, end-1));
    }

}
