package learning;

import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverseWord("GeeksForGeeks"));
        System.out.println(reverseWordUsingStack("GeeksForGeeks"));
        System.out.println(reverseStringUsingTwoPointer("India"));
    }

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

    private static String reverseWord(String string) {
        StringBuilder sb = new StringBuilder(string);
        sb.reverse();
        return sb.toString();
    }
}
