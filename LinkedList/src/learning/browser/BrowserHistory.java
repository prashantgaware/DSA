package learning.browser;

class BrowserNode {
    String url;
    BrowserNode next;
    BrowserNode prev;

    public BrowserNode(String url) {
        this.url = url;
        this.next = null;
        this.prev = null;
    }
}

// This class implements a simple browser history using a doubly linked list.
public class BrowserHistory {
    private BrowserNode current;

    public BrowserHistory(String homepage) {
        current = new BrowserNode(homepage);
    }

    /**
     * Visits a new URL and adds it to the history.
     * @param url the URL to visit
     * Approach:
     *            1. Create a new BrowserNode with the given URL.
     *            2. Set the next pointer of the current node to the new node.
     *            3. Set the previous pointer of the new node to the current node.
     *            4. Update the current pointer to the new node.
     *            Time Complexity: O(1)
     *            Space Complexity: O(1)
     */
    public void visit(String url) {
        BrowserNode newNode = new BrowserNode(url);
        current.next = newNode;
        newNode.prev = current;
        current = newNode;
    }

    /**
     * Moves back in the history by a specified number of steps.
     * @param steps the number of steps to go back
     * @return the URL of the page after going back
     * Approach:
     *           1. While there are steps to go back and the previous node is not null,
     *           decrement the steps and move the current pointer to the previous node.
     *           2. Return the URL of the current node.
     *           Time Complexity: O(steps)
     *           Space Complexity: O(1)
     */
    public String back(int steps) {
        while (steps > 0 && current.prev != null) {
            current = current.prev;
            steps--;
        }
        return current.url;
    }

    /**
     * Moves forward in the history by a specified number of steps.
     * @param steps the number of steps to go forward
     * @return the URL of the page after going forward
     * Approach:
     *           1. While there are steps to go forward and the next node is not null,
     *           decrement the steps and move the current pointer to the next node.
     *           2. Return the URL of the current node.
     *           Time Complexity: O(steps)
     *           Space Complexity: O(1)
     */
    public String forward(int steps) {
        while (steps > 0 && current.next != null) {
            current = current.next;
            steps--;
        }
        return current.url;
    }

    /**
     * Gets the current URL in the browser history.
     * @return the URL of the current page
     * Approach:
     *           1. Return the URL of the current node.
     *           Time Complexity: O(1)
     *           Space Complexity: O(1)
     */
    public String getCurrentUrl() {
        return current.url;
    }
}
