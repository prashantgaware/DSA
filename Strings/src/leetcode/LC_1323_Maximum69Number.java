package leetcode;

public class LC_1323_Maximum69Number {
    /**
     * Given a positive integer num consisting only of digits 6 and 9.
     * @param num the input number
     * @return the maximum number you can get by changing at most one digit.
     * Approach: Convert the number to a string, iterate through the characters,
     * and replace the first occurrence of '6' with '9'. Then convert the string
     * back to an integer and return it.
     */
    public static int max69number(int num) {
        char[] nums = String.valueOf(num).toCharArray();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == '6') {
                nums[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(nums));
    }

    public static void main(String[] args) {
        int num1 = 9669;
        System.out.println(max69number(num1));

        int num2 = 9996;
        System.out.println(max69number(num2));

        int num3 = 9999;
        System.out.println(max69number(num3));
    }
}
