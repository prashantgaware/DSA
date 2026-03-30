import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {
    /**
     * longest substring with k distinct characters
     * @param s string input
     * @param k number of distinct characters allowed
     * @return length of substring
     * Approach:
     * 1. Use a sliding window with two pointers \(`left` and `right`\).
     * 2. Expand `right` and store character frequencies in a `HashMap`.
     * 3. If distinct characters exceed `k`, shrink from `left` until valid.
     * 4. Track the maximum valid window length at each step.
     */
    public static int longestCommonSubstring(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int k = 2;
        System.out.println(longestCommonSubstring(s, k));
    }
}
