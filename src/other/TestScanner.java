package other;

import java.util.*;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class TestScanner {
    public static void main(String[] args) {
        List<Interval> res = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < num; i++) {
            String[] line = sc.nextLine().split(";");

            for (int j = 0; j < line.length; j++) {
                String[] unit = line[j].split(",");
                System.out.println(Arrays.toString(line));
                System.out.println(Arrays.toString(unit));
                res.add(new Interval(Integer.parseInt(unit[0]), Integer.parseInt(unit[1])));
            }
        }

        List<Interval> result = merge(res);
        System.out.println("sdf");
        for (Interval i : result) {
            System.out.println(i.start + " " + i.end);
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) {
            return intervals;
        }

        List<Interval> res = new LinkedList<>();
        Comparator<Interval> c = new Comparator<>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return Integer.compare(i1.start, i2.start);
            }
        };
        // Comparator<Interval> c = (i1, i2) -> Integer.compare(i1.start, i2.start);

        intervals.sort(c);

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (Interval i : intervals) {
            if (i.start <= end) {
                end = Math.max(end, i.end);
            } else {
                res.add(new Interval(start, end));
                start = i.start;
                end = i.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}
