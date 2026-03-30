public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "babad";
        String longestPalindrome = longestPalindromicSubstring(s);
        System.out.println("Longest Palindromic Substring: " + longestPalindrome);
    }

    public static String longestPalindromicSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        String longestPalindromicSubstring = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String subString = s.substring(i, j + 1);
                if (isPalindrome(subString) && subString.length() > longestPalindromicSubstring.length()) {
                    longestPalindromicSubstring = subString;
                }
            }
        }
        return longestPalindromicSubstring;
    }

    private static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
