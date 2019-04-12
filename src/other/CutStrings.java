package other;

import java.util.*;

import java.util.Scanner;

class CutStrings2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int target = in.nextInt();
        int[] strings = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            strings[i] = in.nextInt();
            if (strings[i] > max) max = strings[i];
        }
        double res = binarySearch(strings, 0.0, max, target);
        System.out.println(res);
    }

    private static double binarySearch(int[] strings, double left, double right, int target) {
        while (Math.abs(left - right) > 1e-6) {
            double mid = (left + right) / 2;
            int count = 0;
            for (int len : strings) {
                count += (int) (len / mid);
            }
            if (count < target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }
}

public class CutStrings {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        double[] strings = new double[n];
        String[] data = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            strings[i] = Double.parseDouble(data[i]);
        }
        System.out.println(Arrays.toString(strings));
        cut(strings, n, k);
    }

    // n = 3; k = 4
    public static void cut(double[] s, int n, int k) {
        double[] res = new double[k];
        System.arraycopy(s, 0, res, 0, res.length - 1);
        Arrays.sort(res, 0, n);
        System.out.println(Arrays.toString(res));
        while (n < k) {
            System.out.println(Arrays.toString(res));
            double half = res[n - 1] / 2.0000;
//            System.out.println(res[n - 1] + " " + half + " " + 5/2.0000);
            res[n - 1] = half;
            res[n++] = half;
            Arrays.sort(res, 0, n);
        }
        System.out.println(Arrays.toString(res));
        System.out.printf("%.04f\n", res[0]);
    }
}

