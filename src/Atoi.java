import java.util.Arrays;

public class Atoi {
    public static int myAtoi(String str) {
        int index = 0;
        char[] c = str.toCharArray();
        if (c.length == 0) return 0;

        while (index < c.length && c[index] == ' ')
            index++;
        if (index == c.length) return 0;

        // check sign
        int sign = 1;
        if (c[index] == '-' || c[index] == '+') {
            sign = c[index] == '-' ? -1 : 1;
            index++;
        }

        int res = 0;
        for (; index < c.length; index++) {
            int digit = c[index] - '0';
            if (digit < 0 || digit > 9) break; // not a digit

            // check overflow: && > ||
            if ((Integer.MAX_VALUE / 10 == res && Integer.MAX_VALUE % 10 < digit) || Integer.MAX_VALUE / 10 < res)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            res = res * 10 + digit;
        }
        return res * sign;
    }

    public static int myAtoi3(String str) {
        // check null and empty
        if (str == null || str.isEmpty()) return 0;

        int index = 0, sign = 1, res = 0;
        // this while loop can be replaced as str = str.trim();
        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }

        // check boundary
        if (index == str.length()) return 0;

        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = (str.charAt(index) == '-') ? -1 : 1;
            index++;
        }

        while (index < str.length()) {
            int digit = str.charAt(index) - '0';
            if (digit < 0 || digit > 9) break;

            // check overflow
            if (Integer.MAX_VALUE / 10 == res && Integer.MAX_VALUE % 10 < digit || Integer.MAX_VALUE / 10 < res)
                return (sign == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            res = res * 10 + digit;
            index++;
        }
        return sign * res;
    }

    public static void main(String[] args) {
        String[] s = new String[]{
                "+0 123", "   -42", "42", " "
        };

        for (String ss : s) {
            System.out.println(myAtoi(ss));
        }
    }

}
