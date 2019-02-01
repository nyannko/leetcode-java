public class SearchinRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] == target) return true;
            if (nums[mid] > nums[l]) {
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            } else if (nums[mid] < nums[l]) {
                if (target > nums[mid] && target <= nums[r - 1]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            } else {
                l += 1;
            }
        }
        return false;
    }
}
