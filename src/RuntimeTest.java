import java.lang.reflect.Method;
import java.util.Random;

public class RuntimeTest {
    public static void main(String[] args) throws Exception {
//         O(n) reverse
        testTwoTimesIncrement("reverse", 15, 29);
//         O(n^2) ssort
        testTwoTimesIncrement("ssort", 10, 17);
        testTwoTimesIncrement1("binarySearch", 20, 28);
    }

    public static double sum(double n) {
        long start = System.currentTimeMillis();
        long sum = 0;
        for (long j = 0; j < n; j++) {
            sum += 1;
        }
        return (System.currentTimeMillis() - start) / 1000.0;
    }

    // test different input for simple O(n) algorithm
    public static void testDiffInput() {
        for (int i = 1; i < 11; i++) {
            double n = Math.pow(10, i);
            double time = 0;
            double count = 1;
            for (int j = 0; j < 10; j++) {
                time += sum(n);
            }
            System.out.println("10^" + i + ": " + time / count + " s");
        }
    }

    public static void runDiffTimeComp() {
        int[] arr = {1, 2, 3, 4};
        reverse(arr);
        arr = new int[]{1, 2, 3, 4, 5};
        reverse(arr);
        bsort(arr);
        ssort(arr);
        binarySearch(arr, 2);
        reverseNumber(123);
        test(10);
        System.out.println(isPrime(10));
    }

    public static int[] generateRandomArray(int len, int l, int r) {
        Random rand = new Random();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = rand.nextInt(r - l + 1) + l;
        }
        return arr;
    }

    public static void testTwoTimesIncrement1(String name, int a, int b) throws Exception {
        Method method = RuntimeTest.class.getMethod(name, int[].class, int.class);
        for (int i = a; i < b; i++) {
            int n = (int) Math.pow(2, i); // 2, 4, 8, 16, 32, 64, ...
            int[] arr = generateRandomArray(n, 0, 10000000);
            long start = System.nanoTime();
            method.invoke(null, arr, 0);
            double end = (System.nanoTime() - start);
            System.out.println("i: " + i + ", input size: " + n + ", runtime: " + String.format("%6.1e", end) + " ns");
        }
    }

    public static void testTwoTimesIncrement(String name, int a, int b) throws Exception {
        Method method = RuntimeTest.class.getMethod(name, int[].class);
        for (int i = a; i < b; i++) {
            int n = (int) Math.pow(2, i); // 2, 4, 8, 16, 32, 64, ...
            int[] arr = generateRandomArray(n, 0, 10000000);
            long start = System.currentTimeMillis();
            method.invoke(null, arr);
            double end = (System.currentTimeMillis() - start) / 1000.0;
            System.out.println("i: " + i + ", input size: " + n + ", runtime: " + String.format("%10.6e", end) + " s");
        }
    }
// O(n) reverse()
//i: 22, input size: 4194304, runtime: 1,0e-03 s
//i: 23, input size: 8388608, runtime: 5,0e-03 s
//i: 24, input size: 16777216, runtime: 8,0e-03 s
//i: 25, input size: 33554432, runtime: 1,7e-02 s
//i: 26, input size: 67108864, runtime: 2,8e-02 s
//i: 27, input size: 134217728, runtime: 5,5e-02 s
//i: 28, input size: 268435456, runtime: 1,1e-01 s

// O(n^2) ssort() 4 times increment
//i: 10, input size: 1024, runtime: 6,0e-03 s
//i: 11, input size: 2048, runtime: 9,0e-03 s
//i: 12, input size: 4096, runtime: 4,5e-02 s
//i: 13, input size: 8192, runtime: 1,3e-01 s
//i: 14, input size: 16384, runtime: 4,8e-01 s
//i: 15, input size: 32768, runtime: 1,7e+00 s
//i: 16, input size: 65536, runtime: 6,5e+00 s
//i: 17, input size: 131072, runtime: 2,7e+01 s

    // swap
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // O(n) reverse array
    public static int[] reverse(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len / 2; i++) {
            swap(arr, i, len - 1 - i);
        }
        return arr;
    }

    // O(n)
    public static void print(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(arr[i] + " " + j);
            }
        }
    }

    // O(n^2): (n - 1) + (n - 2) + .. + 0 = (n - 1)n/2
    public static int[] bsort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j, j - 1);
                }
            }
        }
        return arr;
    }

    // O(n^2): selection sort
    public static int[] ssort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i])
                    swap(arr, j, i);
            }
        }
        return arr;
    }

    // O(logn): log_2^n
    public static int binarySearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target)
                l = mid + 1;
            else
                r = mid;
        }
        return -1;
    }

    // O(logn): log_10^n
    public static int reverseNumber(int num) {
        int n = num;
        int res = 0;
        while (n > 0) {
            int r = n % 10;
            n = n / 10;
            res = res * 10 + r;
        }
        return res;
    }

    // O(nlogn)
    public static void test(int n) {
        for (int i = 1; i < n; i += i)  // O(log(n))
            for (int j = 0; j < n; j++) //  O(n)
                System.out.print(i + " "); // 1.., 2.., 4.., 8..
    }

    // O(sqrt(n))
    public static boolean isPrime(int n) {
        for (int i = 2; i * i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

}
