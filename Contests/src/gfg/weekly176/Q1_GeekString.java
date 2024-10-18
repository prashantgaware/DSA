package gfg.weekly176;


public class Q1_GeekString {
    private static boolean hasSubsequence (String str ) {
        String target = "geek";
        int targetIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target.charAt(targetIndex)) {
                targetIndex++;
            }
            if (targetIndex == target.length()) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String str = "abcgeekdef";
        System.out.println(hasSubsequence(str));
    }
}
