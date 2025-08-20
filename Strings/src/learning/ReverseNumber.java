package learning;

import java.util.Stack;

public class ReverseNumber {
    public static void main(String[] args) {
        System.out.println(reverseWordUsingStack("GeeksForGeeks"));
        System.out.println(reverseStringUsingTwoPointer("India"));
        System.out.println(reverseNumber(12345));
    }

    /**
     *
     * @param string
     * @return
     * Approach:
     * 1. Create a stack to hold characters.
     * 2. Iterate through each character in the string and push it onto the stack.
     * 3. Create a StringBuilder to build the reversed string.
     * 4. While the stack is not empty, pop characters from the stack and append
     *   them to the StringBuilder.
     *   5. Convert the StringBuilder to a string and return it.
     * Time Complexity: O(n), where n is the length of the string.
     * Space Complexity: O(n), where n is the length of the string due to the stack and StringBuilder.
     */
    private static String reverseWordUsingStack(String string) {
        Stack<Character> stack = new Stack<>();

        for(char c : string.toCharArray()) {
            stack.push(c);
        }

        StringBuilder reversed = new StringBuilder();

        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }

    /**
     * Reversing String using two pointer approach
     * @param str String
     * @return Reversed String
     */
    private static String reverseStringUsingTwoPointer(String str) {
        char[] charArray = str.toCharArray();
        int left = 0;
        int right = charArray.length-1;

        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            left++;
            right--;
        }

        return new String(charArray);
    }

    /**
     *
     * @param number
     * @return
     */
    private static int reverseNumber(int number) {
        int reversed = 0;

        while (number != 0) {
            int remainder = number%10;
            reversed = (reversed*10) + remainder;
            number = number/10;
        }

        return reversed;
    }
}
