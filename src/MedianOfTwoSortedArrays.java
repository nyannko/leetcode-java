public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int i = 0, j = 0, k = 0;
        double[] arr = new double[l1 + l2];
        double result = 0;

        while (i < l1 && j < l2) {
            if (nums1[i] < nums2[j]) {
                arr[k] = nums1[i];
                i++;
            } else {
                arr[k] = nums2[j];
                j++;
            }
            k++;
        }

        while (i < l1) {
            arr[k] = nums1[i];
            i++;
            k++;
        }
        while (j < l2) {
            arr[k] = nums2[j];
            j++;
            k++;
        }

        int size = l1 + l2;
        if (size % 2 == 0) {
            int index = size / 2;
            result = (arr[index - 1] + arr[index]) / 2;
        } else {
            int index = (size + 1) / 2;
            result = arr[index - 1];
        }
        return result;
    }

    public static void main(String[] args) {
        int nums1[] = {1, 2};
        int nums2[] = {3, 4};
        MedianOfTwoSortedArrays m = new MedianOfTwoSortedArrays();
        System.out.println(m.findMedianSortedArrays(nums1, nums2));
    }
}
