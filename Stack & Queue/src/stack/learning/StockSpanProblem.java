package stack.learning;

// https://www.geeksforgeeks.org/the-stock-span-problem/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Stock Span Problem
 * Problem Statement:
 * The stock span problem is a financial problem where we have a series of n daily price quotes
 * for a stock and we need to calculate the span of stock’s price for all n days.
 * The span Si of the stock’s price on a given day i is defined as the maximum
 * number of consecutive days just before the given day, for which the price of the stock on
 * the current day is less than or equal to its price on the given day.
 * For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85},
 * then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}
 */

public class StockSpanProblem {

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        List<Integer> span = calculateSpan(prices);
        System.out.println("Stock Span: " + span);
    }

    /**
     * Function to calculate the span of stock prices
     * @param prices array of stock prices
     * @return list of span values
     * Approach:
     * 1. Initialize an empty stack to keep track of indices of days.
     * 2. Initialize an empty list to store the span values.
     * 3. Iterate through each day's price:
     *    a. While the stack is not empty and the price of the current day is
     *       greater than or equal to the price of the day at the index stored at the
     *       top of the stack, pop the stack.
     *    b. If the stack becomes empty, it means there are no previous days with
     *       a higher price, so the span is the current day index + 1.
     *    c. If the stack is not empty, the span is the difference between the
     *       current day index and the index at the top of the stack.
     *    d. Push the current day index onto the stack.
     * 4. Return the list of span values.
     * Time Complexity: O(n) - Each element is pushed and popped from the stack at most once.
     * Space Complexity: O(n) - In the worst case, the stack can hold all elements.
     * Dry Run:
     * For prices = {100, 80, 60, 70, 60, 75, 85}
     * Day 0: price = 100, stack = [], span = [1], stack after push = [0]
     * Day 1: price = 80, stack = [0], span = [1, 1], stack after push = [0, 1]
     * Day 2: price = 60, stack = [0, 1], span = [1, 1, 1], stack after push = [0, 1, 2]
     * Day 3: price = 70, stack = [0, 1, 2], pop 2, span = [1, 1, 1, 2], stack after push = [0, 1, 3]
     * Day 4: price = 60, stack = [0, 1, 3], span = [1, 1, 1, 2, 1], stack after push = [0, 1, 3, 4]
     * Day 5: price = 75, stack = [0, 1, 3, 4], pop 4, pop 3, span = [1, 1, 1, 2, 1, 4], stack after push = [0, 1, 5]
     * Day 6: price = 85, stack = [0, 1, 5], pop 5, pop 1, span = [1, 1, 1, 2, 1, 4, 6], stack after push = [0, 6]
     */
    public static List<Integer> calculateSpan(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> span = new ArrayList<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                span.add(i + 1);
            } else {
                span.add(i - stack.peek());
            }
            stack.push(i);
        }
        return span;
    }

}
