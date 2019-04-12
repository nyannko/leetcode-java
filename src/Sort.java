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

    public static void insertionSort(int[] nums) {
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

    public static void insertionSort1(int[] nums) {
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
        // create two test arrays
        int length = 100000;
        int[] nums = Sort.randomArray(length, 1, length);
        int[] copy1 = new int[length];
        System.arraycopy(nums, 0, copy1, 0, length);
        int[] copy2 = Arrays.copyOf(nums, length); // easier than system.arraycopy

        Sort.testSort("insertionSort", nums);
        Sort.testSort("insertionSort1", copy1);
        Sort.testSort("selectionSort", copy2);
    }
}
