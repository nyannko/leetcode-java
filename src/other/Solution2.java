package other;

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            int count = Integer.parseInt(sc.nextLine());
            String[] data = sc.nextLine().split(" ");
            int[] res = new int[count];
            for (int j = 0; j < data.length; j++) {
                res[j] = Integer.parseInt(data[j]);
            }
//            System.out.println(Arrays.toString(res));
            System.out.println(Arrays.toString(res));
            System.out.println(candy(res));
        }
    }

    // ?? how
//    public static int loop(int[] data) {
//        int len = data.length;
//        int[] candy = new int[len];
//        Arrays.fill(candy, 1);
//
//        for (int i = 0; i < data.length; i++) {
//            candy(data, candy, i);
//        }
//
//        int sum = 0;
//        System.out.println(Arrays.toString(candy));
//        for (int n : candy) {
//            sum += n;
//        }
//        return sum;
//    }

    public static int candy(int[] ratings) {
        int length = ratings.length;
        int[] candy = new int[length];
        Arrays.fill(candy, 1);

        for (int i = 1; i < length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }

        for (int i = length - 2; i >= 0; i--) {
            // if (ratings[i] > ratings[i + 1] && candy[i] <= candy[i + 1]) {
            //     candy[i] = candy[i + 1] + 1;
            // }
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
                // candy[i] = candy[i + 1] + 1;
            }
        }
        System.out.println(Arrays.toString(candy));

        int sum = 0;
        for (int n : candy) {
            sum += n;
        }
        return sum;
    }


    public static boolean isInc(int a, int b) {
        if (a < b) return true;
        return false;
    }

    public static int method(int[] data) {
        int[] res = new int[data.length];
        Arrays.fill(res, 1);
        for (int i = 1; i < data.length; i++) {
            if (isInc(data[i - 1], data[i])) {
                res[i] = res[i - 1] + 1;
            }
        }
        for (int i = data.length - 1; i > 0; i--) {
            if (isInc(data[i], data[i - 1])) {
                res[i - 1] = Math.max(res[i - 1], res[i] + 1);
            }
        }

        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += res[i];
        }
        return sum;
    }

    //https://paste.ubuntu.com/p/zrftPBmJvm/
    // getString
//3
//2
//1 2
//4
//1 2 3 3
//10
//1 5 4 2 3 9 8 7 100 5
}
