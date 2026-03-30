/**
 * Longest common substring without repeating characters
 * Given a string s, find the length of the longest substring without repeating characters.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(LongestCommonSubstring.longestCommonSubstringUsingSet(str));
        System.out.println(LongestCommonSubstring.longestCommonSubstringUsingMap(str));
    }

    /**
     * longest substring using hashset
     * @param s input
     * @return length of substring
     * Approach:
     * 1.
     */
    public static int longestCommonSubstringUsingSet(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            if (set.contains(s.charAt(right))) {
                set.remove(s.charAt(right));
                left++;
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    /**
     * Longest substring without repeating characters using a HashMap.
     * @param s input string
     * @return length of the longest substring without repeating characters
     * Approach:
     * 1. Use a sliding window with two pointers: `left` and `right`.
     * 2. Store each character's latest index in `map`.
     * 3. If current character was seen, move `left` to `max(left, lastIndex + 1)`.
     * 4. Update `maxLen` using current window size: `right - left + 1`.
     * Dry run for `abcabcbb`:
     * - r=0(a): left=0, maxLen=1
     * - r=1(b): left=0, maxLen=2
     * - r=2(c): left=0, maxLen=3
     * - r=3(a): seen at 0, left=1, maxLen=3
     * - r=4(b): seen at 1, left=2, maxLen=3
     * - r=5(c): seen at 2, left=3, maxLen=3
     * - r=6(b): seen at 4, left=5, maxLen=3
     * - r=7(b): seen at 6, left=7, maxLen=3
     * Final answer: `3`.
     */
    public static int longestCommonSubstringUsingMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
