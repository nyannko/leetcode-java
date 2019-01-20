public class Sqrt {
    public int mySqrt(int x) {
        if (x < 2) return x;

        int l = 0, r = x / 2 + 1;

        while (l < r) {
            int m = (l + r) >>> 1;
            if (Math.pow(m, 2) == x) return m;
            if (Math.pow(m, 2) < x) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l - 1;
    }

    public int mySqrt1(int x) {
        if (x < 2) return x;
        int l = 1,
                r = x / 2 + 1;

        while (l < r) {
            int m = (l + r) >>> 1;
            if (x / m == m) return m;
            if (x / m > m) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l - 1;
    }

    public int mySqrt3(int x) {
        if (x < 2) return x;

        int l = 0, r = x / 2;

        while (l <= r) {
            int m = (l + r) >>> 1;
            if (Math.pow(m, 2) == x) return m;
            if (Math.pow(m, 2) < x) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l - 1;
    }

    public int mySqrt4(int x) {
        if (x < 2) return x;
        int l = 1,
                r = x / 2;

        while (l <= r) {
            int m = (l + r) >>> 1;
            if (x / m == m) return m;
            if (x / m > m) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l - 1;
    }
}
