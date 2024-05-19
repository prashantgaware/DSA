package learning;

import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverseWord("GeeksForGeeks"));
        System.out.println(reverseWordUsingStack("GeeksForGeeks"));
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

    private static String reverseWord(String string) {
        StringBuilder sb = new StringBuilder(string);
        sb.reverse();
        return sb.toString();
    }
}
