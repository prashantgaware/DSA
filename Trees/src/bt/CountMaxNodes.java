package bt;

public class CountMaxNodes {

    static int countMaxNodesInTree(int i) {
        return (int)Math.pow(2, i-1);
    }

    static int countMaxNodesInTreeUsingShiftOperator(int i) {
        return 1 << i-1;
    }

    /**
     * Iterative approach
     * @param i - height of tree
     * @return - maximum number of nodes in a tree of height i
     * Approach:
     * 1. Initialize count = 1
     * 2. Loop from 1 to i
     * 3. count = count * 2
     * 4. Return count
     */
    static int countMaxNodesInTreeUsingIterative(int i) {
        int count = 1;
        for (int j = 1; j < i; j++) {
            count *= 2;
        }
        return count;
    }

    /**
     * Brute force approach
     * @param i - height of tree
     * @return - maximum number of nodes in a tree of height i
     * Approach:
     * 1. Initialize count = 0
     * 2. Loop from 0 to i-1
     * 3. count += 2^j
     * 4. Return count
     */
    static int countMaxNodesBruteForce(int i) {
        int count = 0;
        for (int j = 0; j < i; j++) {
            count += (int) Math.pow(2, j);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(CountMaxNodes.countMaxNodesInTree(5));
        System.out.println(CountMaxNodes.countMaxNodesInTreeUsingShiftOperator(5));
        System.out.println(CountMaxNodes.countMaxNodesInTreeUsingIterative(5));
        System.out.println(CountMaxNodes.countMaxNodesBruteForce(5));
    }

}
