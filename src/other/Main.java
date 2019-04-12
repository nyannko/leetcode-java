package other;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < scores.length; i++)
            scores[i] = sc.nextInt();
        int[] gifts = new int[n];
        for (int i = 0; i < n; i++) {
            if (gifts[i] == 0)
                cal(scores, gifts, i);
        }
        sumGifts(gifts);
    }

    private static void sumGifts(int[] gifts) {
        int sum = 0;
        for (int i = 0; i < gifts.length; i++)
            sum += gifts[i];
        System.out.println(sum);

    }

    private static int cal(int[] scores, int[] gifts, int i) {
        int n = scores.length;
        if (gifts[i] != 0)
            return gifts[i];
        if (scores[i] <= scores[(i + 1) % n] && scores[i] <= scores[(n + i - 1) % n]) {
            gifts[i] = 1;
        }
        if (scores[i] > scores[(i + 1) % n] && scores[i] <= scores[(n + i - 1) % n]) {
            gifts[i] = cal(scores, gifts, (i + 1) % n) + 1;
        }
        if (scores[i] <= scores[(i + 1) % n] && scores[i] > scores[(n + i - 1) % n]) {
            gifts[i] = cal(scores, gifts, (n + i - 1) % n) + 1;
        }
        if (scores[i] > scores[(i + 1) % n] && scores[i] > scores[(n + i - 1) % n]) {
            gifts[i] = (cal(scores, gifts, (i + 1) % n) + 1) > (cal(scores, gifts, (n + i - 1) % n) + 1) ? (cal(scores, gifts, (i + 1) % n) + 1) : (cal(scores, gifts, (n + i - 1) % n) + 1);
        }
        return gifts[i];
    }
}
