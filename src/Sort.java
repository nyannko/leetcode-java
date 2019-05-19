import java.util.Arrays;
import java.util.Random;
import java.lang.reflect.Method;

public class Sort {
    public static int[] randomArray(int n, int l, int r) {
        Random rand = new Random();
        if (l >= r) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(r - l + 1) + l;
        }
        return arr;
    }

    public static int[] nearlySortedArray(int n, int swapTimes) {
        Random rand = new Random();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }
        // swap several pairs in a sorted array
        for (int i = 0; i < swapTimes; i++) {
            int x = rand.nextInt(n); // the upper bound is exclusive
            int y = rand.nextInt(n);
            while (y == x)          // maybe add this to reduce self duplications
                y = rand.nextInt(n);
            swap(nums, x, y);
        }
        return nums;
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] < arr[i])
                return false;
        }
        return true;
    }

    public static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void insertionSort1(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j]; // shift bigger number to right
                j--; // compare previous
            }
            nums[j + 1] = key;
        }
    }

    public static void insertionSort1_1(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] > key) {
                nums[j] = nums[j - 1]; // shift bigger number to right
                j--; // compare previous
            }
            nums[j] = key;
        }
    }

    public static void insertionSort1_2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j;
            for (j = i; j > 0 && nums[j - 1] > key; j--) {
                nums[j] = nums[j - 1]; // shift bigger number to right
            }
            nums[j] = key;
        }
    }

    public static void insertionSort2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0 && nums[j - 1] > nums[j]; j--) {
                swap(nums, j, j - 1);
            }
        }
    }

    public static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            swap(nums, min, i); // swap the min value with current index
        }
    }

    public static void testSort(String sortName, int[] nums) throws Exception {
        Method method = Sort.class.getMethod(sortName, int[].class);
        long startTime = System.currentTimeMillis();
        method.invoke(null, nums);
        long timeElapsed = System.currentTimeMillis() - startTime;
        System.out.println(sortName + ": " + timeElapsed + " ms");
    }

    public static void main(String[] args) throws Exception {
        // create two getString arrays
        int length = 100000;
        String[] func = {"insertionSort1", "insertionSort1_1", "insertionSort1_2",
                "insertionSort2", "selectionSort"};
        int[] random = Sort.randomArray(length, 1, length);
        int[] dummy = Arrays.copyOf(random, length);
        System.out.println("Dummy call:");
        Sort.testSort("insertionSort1", dummy); // dummy call
        // System.arraycopy(random, 0, copy1, 0, length); //alternatives
        System.out.println("Test Random Array:");
        for (int i = 0; i < func.length; i++) {
            int[] c = Arrays.copyOf(random, length);
            Sort.testSort(func[i], c);
        }

        System.out.println("Test Nearly Sorted Array:");
        int[] sorted = Sort.nearlySortedArray(length, 10);
        for (int i = 0; i < func.length; i++) {
            int[] s = Arrays.copyOf(sorted, length);
            Sort.testSort(func[i], s);
        }
    }
}
