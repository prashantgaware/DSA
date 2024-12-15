package bt;

public class CountMaxNodes {

    static int countMaxNodesInTree(int i) {
        return (int)Math.pow(2, i-1);
    }

    public static void main(String[] args) {
        System.out.println(CountMaxNodes.countMaxNodesInTree(5));
    }

}
