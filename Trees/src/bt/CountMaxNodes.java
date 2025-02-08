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

    public static void main(String[] args) {
        System.out.println(CountMaxNodes.countMaxNodesInTree(5));
        System.out.println(CountMaxNodes.countMaxNodesInTreeUsingShiftOperator(5));
        System.out.println(CountMaxNodes.countMaxNodesInTreeUsingIterative(5));
    }

}
