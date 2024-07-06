package learning;

public class Test02 {
    public static void main(String[] args) {
        int n = fun(16);
        System.out.println(n);
    }

    private static int fun(int i) {
        if (i == 1)
            return 0;
        else
            return 1 + fun(i/2);
    }
}
