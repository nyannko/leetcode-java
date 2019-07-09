import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PerfectSquare {
    public static int numSquares(int n) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> s = new HashSet<>();
        if (n != 0) q.offer(n);
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            res++;
            for (int i = 0; i < size; i++) {
                int val = q.poll();
                if (!s.add(val)) continue;
                for (int j = 0; j * j <= val; j++) {
                    if (val - j * j == 0) return res;
                    q.offer(val - j * j);
                }
            }
        }
        return res; // if n == 0
    }

    public static void main(String[] args) {
        numSquares(8);
    }
}
