package learning;

import java.util.Stack;

public class BalancedParenthesis {
    /**
     * This method checks if the parenthesis is balanced or not.
     * @param string - input string
     * @return true if the parenthesis is balanced, false otherwise
     */
    private static boolean isBalancedParenthesis(String string) {
        Stack<Character> stack = new Stack<>();

        for (char c : string.toCharArray()) {
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    /**
     * This method is more optimized than the previous one.
     * @param str - input string
     * @return true if the parenthesis is balanced, false otherwise
     */
    private static boolean isBalancedParenthesis2(String str) {
        Stack <Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            if (c == ')' || c == ']' || c == '}') {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    private static boolean isValidParenthesis(String s) {
        Stack<Character> stack = new Stack<>();
        if (s== null || s.length() <= 0)
            return true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else
                    return false;
            } else if (s.charAt(i) == '}') {
                if (!stack.isEmpty() && stack.peek() == '{')
                    stack.pop();
                else
                    return false;
            } else if (s.charAt(i) == ']') {
                if (!stack.isEmpty() && stack.peek() == '[')
                    stack.pop();
                else
                    return false;
            } else {
                stack.push(s.charAt(i));
            }
        }

        if (stack.isEmpty())
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isBalancedParenthesis("(({}[[()]]))"));
        System.out.println(isBalancedParenthesis2("(({}[[(]]))"));
        System.out.println(isValidParenthesis("(({}[[()]]))"));
    }
}
