import java.util.Arrays;

public class QuickSort {
    public void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int mid = partition3(nums, l, r);
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

    public static void main(String[] args) {
        int[] a = {12, 6, 1, 15, 0, 5, 11, 10};
        int[] b = Arrays.copyOf(a, a.length);
        int[] c = Arrays.copyOf(a, a.length);

        QuickSort q = new QuickSort();

        q.partition1(a, 0, a.length - 1); // [10, 6, 1, 11, 0, 5, 12, 15]
        q.partition2(b, 0, b.length - 1); // [10, 6, 1, 11, 0, 5, 12, 15]
        q.partition3(c, 0, c.length - 1); // [6, 1, 0, 5, 10, 15, 11, 12]
        q.quickSort(a, 0, a.length - 1);
        q.quickSort(b, 0, b.length - 1);
        q.quickSort(c, 0, c.length - 1);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));
    }
}
