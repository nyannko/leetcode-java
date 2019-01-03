public class ClimbingStairs {
    public int climbStairs(int n) {
        int a = 1, b = 1;
        while (n-- > 0) {
            a = (b += a) - a; // new a = new b  - old a
        }
        return a;
    }

    public int fibonacci(int n) {
        if (n < 2) {
            return n;
        } else {
            int[] ans = new int[n + 1];
            ans[0] = 0;
            ans[1] = 1;
            for (int i = 2; i < n + 1; i++) {
                ans[i] = ans[i - 1] + ans[i - 2];
            }
            return ans[n];
        }
    }


    public int fibonacci1(int n) {
        if (n < 2) {
            return n;
        } else {
            return fibonacci1(n - 1) + fibonacci1(n - 2);
        }
    }

    public static void main(String[] args) {
        ClimbingStairs c = new ClimbingStairs();
        System.out.println(c.climbStairs(5));
    }
}
