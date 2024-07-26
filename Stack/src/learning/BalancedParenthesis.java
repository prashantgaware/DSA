package learning;

import java.util.Stack;

public class BalancedParenthesis {
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

    public static void main(String[] args) {
        System.out.println(isBalancedParenthesis("(({}[[()]]))"));
    }
}
