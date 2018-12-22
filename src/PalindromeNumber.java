public class PalindromeNumber {
    // Use StringBuilder
    public boolean isPalindrome(int x) {
        String str = Integer.toString(x);
        String sb = new StringBuilder(str).reverse().toString();
        // String sb = new StringBuffer(str).reverse().toString();
        return sb.equals(str);
    }

    public boolean isPalindrome1(int x) {

        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int rev = 0;
        while (x > rev) {
            System.out.println(x + " a " + rev);
            rev = rev * 10 + x % 10;
            System.out.println(x + " b " + rev);
            x = x / 10;
        }
        System.out.println(x + " o " + rev);
        return (x == rev || x == rev / 10);
    }

    public boolean isPalindrome2(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int rev = 0;
        int res = x;
        while (x > 0) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        System.out.println(res + " " + rev);
        return rev == res;
    }

    public static void main(String[] args) {
        PalindromeNumber p = new PalindromeNumber();
        p.isPalindrome1(121);
    }
}
