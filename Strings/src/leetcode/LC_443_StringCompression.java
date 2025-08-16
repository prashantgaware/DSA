package leetcode;

/*
    443. String Compression
    Medium
    Topics
    Companies
    Hint
    Given an array of characters chars, compress it using the following algorithm:

    Begin with an empty string s. For each group of consecutive repeating characters in chars:

    If the group's length is 1, append the character to s.
    Otherwise, append the character followed by the group's length.
    The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.

    After you are done modifying the input array, return the new length of the array.

    You must write an algorithm that uses only constant extra space.



    Example 1:

    Input: chars = ["a","a","b","b","c","c","c"]
    Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
    Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
    Example 2:

    Input: chars = ["a"]
    Output: Return 1, and the first character of the input array should be: ["a"]
    Explanation: The only group is "a", which remains uncompressed since it's a single character.
    Example 3:

    Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
    Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
    Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".


    Constraints:

    1 <= chars.length <= 2000
    chars[i] is a lowercase English letter, uppercase English letter, digit, or symbol.
*/

public class LC_443_StringCompression {

    /**
     * Compresses the input character array in-place and returns the new length of the array.
     * @param chars the character array to be compressed
     * @return the new length of the compressed character array
     * Approach:
     * 1. Initialize an index to keep track of the position in the compressed array.
     * 2. Iterate through the character array using a while loop.
     * 3. For each character, count the number of consecutive occurrences.
     * 4. Append the character to the compressed array.
     * 5. If the count is greater than 1, convert the count to a string
     * and append each digit to the compressed array.
     * 6. Return the new length of the compressed array.
     */
    private static int compress(char[] chars) {
        int index = 0;
        int i = 0;

        while (i < chars.length) {
            char curr_char = chars[i];
            int count  = 0;

            // counting the number of character
            while (i < chars.length && chars[i] == curr_char) {
                i++;
                count++;
            }

            // appending the character and its count
            chars[index] = curr_char;
            index++;

            // if count is in two digits, slicing it
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[index] = c;
                    index++;
                }
            }
        }

        return index;
    }

    public static void main(String[] args) {
        // Example 1
        char[] chars1 = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int newLength1 = compress(chars1);
        System.out.println("New Length: " + newLength1);
        System.out.print("Compressed Array: ");
        for (int i = 0; i < newLength1; i++) {
            System.out.print(chars1[i] + " ");
        }
        System.out.println();

        // Example 2
        char[] chars2 = {'a'};
        int newLength2 = compress(chars2);
        System.out.println("New Length: " + newLength2);
        System.out.print("Compressed Array: ");
        for (int i = 0; i < newLength2; i++) {
            System.out.print(chars2[i] + " ");
        }
        System.out.println();

        // Example 3
        char[] chars3 = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        int newLength3 = compress(chars3);
        System.out.println("New Length: " + newLength3);
        System.out.print("Compressed Array: ");
        for (int i = 0; i < newLength3; i++) {
            System.out.print(chars3[i] + " ");
        }
        System.out.println();
    }
}
