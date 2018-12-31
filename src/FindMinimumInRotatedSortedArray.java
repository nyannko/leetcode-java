public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int first = 0;
        int last = nums.length - 1;
        while (first < last) {
            int mid = first + (last - first) / 2;
            if (nums[mid] < nums[last]) {
                last = mid;
            } else if (nums[mid] > nums[last]) {
                first = mid + 1;
            } else {
                last--;
            }
        }
        return nums[first];
    }
}
