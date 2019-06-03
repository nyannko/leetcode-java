import util.Interval;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public static int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0) return 0;
        // sort with the comparator, and you should know why compare with end value
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1.end != o2.end)
                return Integer.compare(o1.end, o2.end); // boolean --> int
            return Integer.compare(o1.start, o2.start);
        });

        // greedy
        int res = 1;
        int pre = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= intervals[pre].end) {
                res++; // intervals with non-overlapping
                pre = i;
            }
        }
        return intervals.length - res; // intervals that need to be deleted
    }

    public static void printInterval(Interval[] intervals) {
        for (Interval interval : intervals) {
            System.out.println(interval.start + " " + interval.end);
        }
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[4];
        intervals[0] = new Interval(1, 4);
        intervals[1] = new Interval(2, 3);
        intervals[2] = new Interval(3, 4);
        intervals[3] = new Interval(1, 3);
        eraseOverlapIntervals(intervals);
        int[][] arr = {{1, 4}, {1, 3}, {2, 3}, {3, 4}};
        Arrays.sort(arr, new Comparator<>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
                return Integer.compare(a[1], b[1]);
            }
        });
    }
}

// Create an interval comparator class(could also be an anonymous class) to make intervals in ascending order
class IntervalComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval o1, Interval o2) {
        // -1 ascending: o1 < o2
        // 0 equality: o1 = o2
        // 1 descending: o1 > o2
        if (o1.start != o2.start)
            return Integer.compare(o1.start, o2.start);
        return Integer.compare(o1.end, o2.end);
    }
}
