public class Pow {
    public double myPow(double x, int n) {
        if (n < 0) return 1 / dfs(x, -n);
        return dfs(x, n);
    }

    public double dfs(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        double v = dfs(x, n / 2);
        if (n % 2 == 0) {
            return v * v;
        } else {
            return v * v * x;
        }
    }
}
