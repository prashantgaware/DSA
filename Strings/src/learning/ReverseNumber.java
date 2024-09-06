package learning;

import java.util.Stack;

public class ReverseNumber {
    public static void main(String[] args) {
//        System.out.println(reverseWordUsingStack("GeeksForGeeks"));
//        System.out.println(reverseStringUsingTwoPointer("India"));
        System.out.println(reverseNumber(12345));
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
