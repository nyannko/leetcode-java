public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        int m = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != elem) {
                A[m] = A[i];
                m++;
            }
        }
        return m;
    }

    public int removeElement3(int[] A, int elem) {
        int len = A.length;
        for (int i = 0; i < len; ++i) {
            while (A[i] == elem && i < len) {
                A[i] = A[--len];
            }
        }
        return len;
    }

    public int removeElement1(int[] nums, int val) {
        int m = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[m++] = nums[i];
            }
        }
        return m;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        RemoveElement r = new RemoveElement();
        r.removeElement3(nums, 3);
    }
}
