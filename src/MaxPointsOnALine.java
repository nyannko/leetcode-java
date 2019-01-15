import java.util.HashMap;
import java.util.Map;

//class Tuple<X, Y> {
//    public final X x;
//    public final Y y;
//
//    public Tuple(X x, Y y) {
//        this.x = x;
//        this.y = y;
//    }
//}

class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (!(other instanceof Point)) return false;
        Point o = (Point) other;
        return this.x == o.x && this.y == o.y;
    }

    public int hashCode() {
        return x * 4 + y * 3;
    }
}

class Solution {
    public int maxPoints(Point[] points) {
        if (points.length <= 2) {
            return points.length;
        }
        int result = 0;
        int size = points.length;
        Map<Point, Integer> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            int curmax = 0,
                    overlap = 0;
            map.clear();
            for (int j = i + 1; j < size; j++) {
                int dx = points[j].x - points[i].x,
                        dy = points[j].y - points[i].y;
                if (dx == 0 && dy == 0) {
                    overlap++;
                    continue;
                }
                int gcd = getGCD(dx, dy);
                dx /= gcd;
                dy /= gcd;
                Point t = new Point(dx, dy);
                // alternative to if-else
                Integer count = map.get(t);
                map.put(t, map.get(t) == null ? 1 : count + 1);
//                if (map.containsKey(t)) {
//                    int count = map.get(t) + 1;
//                    map.put(t, count);
//                } else {
//                    map.put(t, 1);
//                }
                curmax = Math.max(curmax, map.get(t));
            }
            result = Math.max(result, curmax + overlap + 1);
        }
        return result;
    }

    public int getGCD(int i, int j) {
        if (j == 0) {
            return i;
        }
        return getGCD(j, i % j);
    }

    public int maxPoints2(Point[] points) {
        if (points == null) {
            return 0;
        }

        if (points.length <= 2) {
            return points.length;
        }
        int result = 2;
        for (int i = 1; i < points.length; i++) {
            int count = 0;
            long a = points[i].x;
            long b = points[i].y;
            long dx = a - points[i - 1].x;
            long dy = b - points[i - 1].y;
            if (dx == 0 && dy == 0) {
                for (int j = 0; j < points.length; j++) {
                    if (points[j].x == a && points[j].y == b)
                        count++;
                }
            } else {
                for (int j = 0; j < points.length; j++) {
                    if ((points[j].x - a) * dy == (points[j].y - b) * dx)
                        count++;
                }
            }
            result = Math.max(result, count);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution a = new Solution();
        Point[] list = new Point[6];
        list[0] = new Point(1, 1);
        list[1] = new Point(3, 2);
        list[2] = new Point(5, 3);
        list[3] = new Point(4, 1);
        list[4] = new Point(2, 3);
        list[5] = new Point(1, 4);
        System.out.println(a.maxPoints(list));
        System.out.println(new Point(1, 1).equals(new Point(1, 1))); // test equals
    }
}
