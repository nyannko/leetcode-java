class Solution {
    public int search(int[] nums, int target) {
        int first = 0;
        int last = nums.length - 1;
        while (first <= last) {
            int mid = (first + last) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution a = new Solution();
        int[] arr = {-1, 0, 3, 5, 9, 12};
        System.out.println(a.search(arr, 13));
    }
}