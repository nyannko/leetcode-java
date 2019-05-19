import java.util.Arrays;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CountPrimes {
    public static int[] countPrimes1(int n) {
        int[] res = new int[n];
        int pointer = 0;
        int num = 2;
        while (pointer < n) {
            if (isPrime(num)) {
                res[pointer] = num;
                pointer++;
            }
            num++;
        }
        return res;
    }

    public static boolean isPrime(int n) {
        int count = 0;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            count++;
            if ((n % i) == 0) return false;
        }
        System.out.println(count);
        return true;
    }

    public static int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            System.out.println(i + " " + Arrays.toString(notPrime));
            if (notPrime[i]) continue;
            System.out.println("i: " + i);
            count++;
            for (int j = 2; i * j < n; j++) {
                System.out.println(i + " " + j + " " + i * j);
                notPrime[i * j] = true;
            }
        }
        return count;
    }


    public static void main(String[] args) {
//        System.out.println(Arrays.toString(countPrimes(10)));
        System.out.println(countPrimes(10));
    }
}
