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
                if (map.containsKey(t)) {
                    int count = map.get(t) + 1;
                    map.put(t, count);

                } else {
                    map.put(t, 1);
                }
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
