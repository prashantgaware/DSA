package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. Roman to Integer
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * Example 1:
 * Input: s = "III"
 * Output: 3
 * Example 2:
 * Input: s = "IV"
 * Output: 4
 * Example 3:
 * Input: s = "IX"
 * Output: 9
 * Example 4:
 * Input: s = "LVIII"
 * Output: 58
 * Example 5:
 * Input: s = "MCMXCIV"
 * Output: 1994
 */

public class LC_13_RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("III")); // 3
        System.out.println(romanToInt("IV")); // 4
        System.out.println(romanToInt("IX")); // 9
        System.out.println(romanToInt("LVIII")); // 58
        System.out.println(romanToInt("MCMXCIV")); // 1994

        System.out.println(romanToIntUsingHashMap("III")); // 3
        System.out.println(romanToIntUsingHashMap("IV")); // 4
        System.out.println(romanToIntUsingHashMap("IX")); // 9
        System.out.println(romanToIntUsingHashMap("LVIII")); // 58
        System.out.println(romanToIntUsingHashMap("MCMXCIV")); // 1994
    }

    public static int romanToInt(String s) {
        int result = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int value = getRomanValue(c);

            if (value < prevValue) {
                result -= value;
            } else {
                result += value;
            }
            prevValue = value;
        }

        return result;
    }

    private static int getRomanValue(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0; // Invalid character
        };
    }

    public static int romanToIntUsingHashMap(String s){
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int value = romanMap.get(c);

            if (value < prevValue) {
                result -= value;
            } else {
                result += value;
            }
            prevValue = value;
        }

        return result;
    }
}
