package other;

import java.util.Scanner;

public class Changes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cost = in.nextInt();
        in.close();
        int remaining = 1024 - cost;
        int res = 0;
        int[] changes = {64, 16, 4, 1};
        for (int i = 0; i < changes.length; i++) {
            res += remaining / changes[i];
            remaining = remaining % changes[i];
        }
        System.out.println(res);
    }
}
