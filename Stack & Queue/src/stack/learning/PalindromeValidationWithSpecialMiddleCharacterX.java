package stack.learning;

// https://www.geeksforgeeks.org/check-if-a-given-string-is-palindrome-or-not-when-one-character-can-be-removed/

/**
 * Palindrome Validation With Special Middle Character 'x'
 * Given a string, check if it can be converted to a palindrome by removing at most one character.
 * The string may contain the special character 'x', which can be ignored when checking for palindrome.
 * For example, the string "abaxab" can be converted to a palindrome by removing the character 'x'.
 * The string "abaxabx" can also be converted to a palindrome by ignoring the 'x' characters.
 */

public class PalindromeValidationWithSpecialMiddleCharacterX {
    private static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) == 'x') {
                i++;
                continue;
            }

            if (str.charAt(j) == 'x') {
                j--;
                continue;
            }

            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        String string = "ababaxababa";
        System.out.println(isPalindrome(string));
    }
}
