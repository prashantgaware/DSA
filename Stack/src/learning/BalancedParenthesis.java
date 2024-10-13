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

    public static void main(String[] args) {
        System.out.println(isBalancedParenthesis("(({}[[()]]))"));
        System.out.println(isBalancedParenthesis2("(({}[[(]]))"));
    }
}
