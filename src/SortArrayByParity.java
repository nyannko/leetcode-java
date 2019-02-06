public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int l = 0, r = A.length - 1;
        while (l < r) {
            while (l < r && (A[l] & 1) == 0) l++; // even++
            while (l < r && (A[r] & 1) == 1) r--; // odd--

            int tmp = A[l];  //swap
            A[l] = A[r];
            A[r] = tmp;
        }
        return A;
    }

    public int[] sortArrayByParity2(int[] A) {
        int l = 0, r = A.length - 1;
        while (l < r) {
            while (l < r && isEven(A[l])) l++;
            while (l < r && !isEven(A[r])) r--;

            int tmp = A[l];
            A[l] = A[r];
            A[r] = tmp;
        }
        return A;
    }

    public boolean isEven(int n) {
        return (n & 1) == 0;
    }
}
