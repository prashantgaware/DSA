package leetcode;

public class LC_5_LongestPalindromicSubstring {
    public static boolean isPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return left < right;
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String subString = s.substring(i, j + 1);
                if (isPalindrome(subString, 0, subString.length() - 1)
                        && subString.length() > longest.length()) {
                    longest = subString;
                }
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        String[] testCases = {
                "babad",
                "cbbd",
                "a",
                "ac"
        };

        for (String testCase : testCases) {
            System.out.println("Input: " + testCase + " => Longest Palindromic Substring: " + longestPalindrome(testCase));
        }
    }
}
