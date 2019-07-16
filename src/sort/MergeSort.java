package sort;

import java.util.Arrays;

public class MergeSort {

    public void merge(int[] nums, int l, int mid, int r) {
        int leftLen = mid - l + 1;
        int rightLen = r - mid;
        int[] left = new int[leftLen];
        int[] right = new int[rightLen];

        for (int i = 0; i < leftLen; i++) {
            left[i] = nums[l + i];
        }
        for (int i = 0; i < rightLen; i++) {
            right[i] = nums[mid + 1 + i];
        }

        int i = 0, j = 0, k = l;
        while (i < leftLen && j < rightLen) {
            if (left[i] < right[j]) {
                nums[k] = left[i];
                i++;
            } else {
                nums[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < leftLen) {
            nums[k] = left[i];
            i++;
            k++;
        }

        while (j < rightLen) {
            nums[k] = right[j];
            j++;
            k++;
        }
    }

    public void mergeSort(int[] nums, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSort(nums, l, mid);
            mergeSort(nums, mid + 1, r);
            if (nums[mid] > nums[mid + 1])
                merge(nums, l, mid, r);
        }
    }

    public static void main(String[] args) {
        int[] nums = {8, 6, 2, 3, 1, 5, 7, 4};
        MergeSort ms = new MergeSort();
        ms.mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
