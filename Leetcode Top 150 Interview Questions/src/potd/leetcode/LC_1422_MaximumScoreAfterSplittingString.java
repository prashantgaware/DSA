package potd.leetcode;

public class LC_1422_MaximumScoreAfterSplittingString {
    public static int maxScore(String s) {
        int maxScore = 0;
        int zeros = 0;
        int ones = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones++;
            }
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                zeros++;
            } else {
                ones--;
            }

            maxScore = Math.max(maxScore, zeros + ones);
        }

        return maxScore;
    }

    public static void main(String[] args) {
        System.out.println(maxScore("011101"));
        System.out.println(maxScore("00111"));
        System.out.println(maxScore("1111"));
    }
}
