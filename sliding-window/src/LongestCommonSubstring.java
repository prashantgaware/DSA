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
     *
     * @param s
     * @return
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
