package learning;

public class Test01 {
    public static void main(String[] args) {
        fun(3);
    }

    private static void fun(int i) {
        if (i == 0)
            return;
        fun(i-1);
        System.out.println(i);
        fun(i-1);
    }
}
