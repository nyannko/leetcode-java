class BinarySearch {
    // len(num) - 1 ; mid -1; mid + 1
    public int search1(int[] nums, int target) {
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

    // len(num); mid; mid + 1
    public int search2(int[] nums, int target) {
        int first = 0;
        int last = nums.length;
        while (first < last) {
            int mid = (first + last) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                last = mid;
            } else {
                first = mid + 1;
            }
        }
        return -1;
    }

    // same with search 2
    public int search3(int[] nums, int target) {
        int l = 0, r = nums.length;
        return dfs(nums, l, r, target);
    }

    public int dfs(int[] nums, int l, int r, int target) {
        if (l >= r) {
            return -1;
        }
        int m = l + (r - l) / 2;
        if (nums[m] == target) return m;
        if (nums[m] > target) {
            return dfs(nums, l, m, target);
        } else {
            return dfs(nums, m + 1, r, target);
        }
    }

    // same with search 1
    public int search4(int[] nums, int target) {
        int l = 0,
                r = nums.length - 1;
        return dfs(nums, l, r, target);
    }

    public int dfs2(int[] nums, int l, int r, int target) {
        if (l > r) {
            return -1;
        }
        int m = l + (r - l) / 2;
        if (nums[m] == target) return m;
        if (nums[m] > target) {
            return dfs(nums, l, m - 1, target);
        } else {
            return dfs(nums, m + 1, r, target);
        }

    }

    public static void main(String[] args) {
        BinarySearch a = new BinarySearch();
        int[] arr = {-1, 0, 3, 5, 9, 12};
        System.out.println(a.search1(arr, 13));
    }
}