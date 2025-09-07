package stack.learning;

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
