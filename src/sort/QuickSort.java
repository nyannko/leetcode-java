package sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int mid = partition2_1(nums, l, r);
        quickSort(nums, l, mid - 1);
        quickSort(nums, mid + 1, r);
    }

    // hole
    public int partition1(int[] nums, int l, int r) {
        int pivot = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= pivot) r--;
            nums[l] = nums[r];
            while (l < r && nums[l] < pivot) l++;
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        return l;
    }

    // swap 1
    public int partition2(int[] nums, int l, int r) {
        int pivot = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= pivot) r--;
            swap(nums, l, r);
            while (l < r && nums[l] < pivot) l++;
            swap(nums, l, r);
        }
        return l;
    }

    // swap 2
    public int partition2_1(int[] nums, int l, int r) {
        int pivot = nums[l];
        int lt = l + 1, gt = r;
        while (lt <= gt) {
            while (nums[lt] < pivot && lt <= gt) lt++;
            while (nums[gt] >= pivot && lt <= gt) gt--;
            if (lt < gt) {
                swap(nums, lt, gt);
            }
        }
        swap(nums, l, gt);
        return gt;
    }

    // swap 3
    public void sort2(int[] nums, int l, int r) {
        if (l >= r) return;
        int pivot = nums[l];
        int lt = l + 1, gt = r;
        while (true) {
            while (lt < r && nums[lt] < pivot) lt++;
            while (gt > l + 1 && nums[gt] > pivot) gt--;
            if (lt >= gt) break;
            swap(nums, lt, gt);
            lt++;
            gt--;
        }
        System.out.println(Arrays.toString(nums));
        swap(nums, l, gt);
        sort2(nums, l, gt - 1);
        sort2(nums, gt + 1, r);
    }


    // pIndex
    public int partition3(int[] nums, int l, int r) {
        int pivot = nums[r];
        int pIndex = l;
        for (int i = l; i < r; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, pIndex);
                pIndex += 1;
            }
        }
        swap(nums, r, pIndex);
        return pIndex;
    }

    private void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

    public void sort(int[] nums, int l, int r) {
        if (l >= r) return;
//        int pivot = nums[l];
        int pivot = rand(nums, l, r);
//        int pivot = middleOfThree(nums, l, r);
        int start = l, end = r;
        while (l < r) {
            while (l < r && nums[r] >= pivot) r--;
            if (l < r) {
                nums[l] = nums[r];
                l++;
            }
            while (l < r && nums[l] < pivot) l++;
            if (l < r) {
                nums[r] = nums[l];
                r--;
            }
        }
        nums[l] = pivot;

        sort(nums, start, l - 1);
        sort(nums, l + 1, end);
    }

    public int rand(int[] nums, int l, int r) {
        Random random = new Random();
        int randomIndex = random.nextInt(r - l + 1) + l;
        swap(nums, l, randomIndex);
        return nums[l];
    }

    public int middleOfThree(int[] nums, int l, int r) {
        int mid = l + (r - l) / 2;

        if (nums[l] > nums[r]) swap(nums, l, r);     // l < r
        if (nums[mid] > nums[r]) swap(nums, mid, r); // mid < r
        if (nums[mid] > nums[l]) swap(nums, mid, l); // mid < l < r

        return nums[l];
    }

    public void sort3(int[] nums, int l, int r) {
        if (l >= r) return;
        int lt = l, i = l + 1, gt = r;
        int pivot = nums[l];
        while (i <= gt) {
            if (nums[i] < pivot) {
                swap(nums, lt++, i++);
            } else if (nums[i] > pivot) {
                swap(nums, i, gt--);
            } else {
                i++;
            }
        }
        sort3(nums, l, lt - 1);
        sort3(nums, gt + 1, r);
    }

    public void testSort() {
        int size = 3000;
        int[] a = new int[size];
        Arrays.fill(a, 10);
        int[] c = new int[size + 1000];
        Arrays.fill(c, 10);

        int[] b = new int[size];
        for (int i = 0; i < size; i++) {
            b[i] = size - i;
        }

        QuickSort q = new QuickSort();
        StopWatch stopwatch = new StopWatch();
        stopwatch.start();
        q.sort(a, 0, a.length - 1);
        stopwatch.stop();

        stopwatch.start();
        q.sort(c, 0, c.length - 1);
        stopwatch.stop();

    }

//    public static void measureTime(int[] nums, QuickSort q) {
//        long startTime = System.nanoTime();
//        q.sort(nums, 0, nums.length - 1);
//        long endTime = System.nanoTime() - startTime;
//        System.out.println(endTime);
//    }


    public static void main(String[] args) {
        int[] a = {12, 6, 1, 15, 0, 5, 11, 10};
//        int[] a = {10, 10, 10, 10, 10};
//        int[] a = {12, 6, 18, 18, 1,1,2};
        QuickSort q = new QuickSort();
        q.sort(a, 0, a.length - 1);
//        int[] a = {10, 10, 10, 10, 10, 8, 9, 7, 6, 2, 1, 11};
//        int[] b = Arrays.copyOf(a, a.length);
//        int[] c = Arrays.copyOf(a, a.length);
//        int[] d = Arrays.copyOf(a, a.length);
//
//        QuickSort q = new QuickSort();
//
//        q.partition1(a, 0, a.length - 1); // [10, 6, 1, 11, 0, 5, 12, 15]
//        q.partition2(b, 0, b.length - 1); // [10, 6, 1, 11, 0, 5, 12, 15]
//        q.partition3(c, 0, c.length - 1); // [6, 1, 0, 5, 10, 15, 11, 12]
//        q.quickSort(a, 0, a.length - 1);
//        q.quickSort(b, 0, b.length - 1);
//        q.quickSort(c, 0, c.length - 1);
//        q.quickSort(d, 0, d.length - 1);
        System.out.println(Arrays.toString(a));
//        System.out.println(Arrays.toString(b));
//        System.out.println(Arrays.toString(c));
//        System.out.println(Arrays.toString(d));
    }
}
