package leetcode;

public class LC_58_LengthOfLastWord {
    /**
     * Given a string s consisting of words and spaces, return the length of the last word in the string.
     * @param str
     * @return
     * Approach: Two Pointers
     * 1. Initialize a pointer `i` to the end of the string and a variable `length` to 0.
     * 2. Move the pointer `i` backwards while skipping any trailing spaces.
     * 3. Continue moving the pointer `i` backwards while
     *   counting the length of the last word until a space is
     *   encountered or the beginning of the string is reached.
     * 4. Return the length of the last word.
     * Time Complexity: O(n) - In the worst case, we may need to traverse the entire string.
     * Space Complexity: O(1) - We are using a constant amount of space.
     */
    public static int lengthOfLastWorld(String str) {
        if (str == null || str.isEmpty()) {
            return -1;
        }

        int length = 0;
        int i = str.length() - 1;
        while (i >= 0 && str.charAt(i) == ' ') {
            i--;
        }

        while (i >= 0 && str.charAt(i) != ' ') {
            length++;
            i--;
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWorld("Hello World"));
        System.out.println(lengthOfLastWorld("   fly me   to   the moon  "));
        System.out.println(lengthOfLastWorld("luffy is still joyboy"));
    }
}
