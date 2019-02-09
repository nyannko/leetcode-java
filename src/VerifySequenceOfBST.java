public class VerifySequenceOfBST {
    // verify post order
    public static boolean verifySequenceOfBST(int[] sequence) {
        if (sequence == null) return false;
        // left < mid < right
        return dfs(sequence, 0, sequence.length - 1);
    }

    public static boolean dfs(int[] sequence, int start, int end) {
        if (start >= end) return true;

        // root value
        int root = sequence[end];

        // left tree: find the boundary point
        int i = start;
        while (i < end) {
            if (sequence[i] > root) {
                break;
            }
            i++;
        }

        // right tree: return false if value < root
        int j = i;
        while (j < end) {
            if (sequence[j] < root) {
                return false;
            }
            ++j;
        }

        // recursion
        return dfs(sequence, start, i - 1) && dfs(sequence, i, end - 1);
    }

    // verify preorder: different boundary
    public static boolean verifySequenceOfBST1(int[] sequence) {
        if (sequence == null) return false;
        // left < mid < right
        return dfs1(sequence, 0, sequence.length - 1);
    }

    public static boolean dfs1(int[] sequence, int start, int end) {
        System.out.println(start + " " + end);
        if (start >= end) return true;

        // root value
        int root = sequence[start];
        // left tree: find the boundary point
        int i = start + 1;
        while (i < end) {
            if (sequence[i] > root) {
                break;
            }
            i++;
        }

        // right tree: return false if value < root
        int j = i;
        while (j < end) {
            if (sequence[j] <= root) {
                return false;
            }
            ++j;
        }

        // recursion
        return dfs1(sequence, start + 1, i - 1) && dfs1(sequence, i, end);
    }

    public static void main(String[] args) {
        int[] a = {5, 7, 6, 9, 11, 10, 8};
        int[] b = {7, 4, 6, 5};
        int[] c = {8, 6, 5, 7, 10, 9, 11};
        int[] d = {0, 6, 5, 7, 0, 9, 0};
        System.out.println(verifySequenceOfBST(a));
        System.out.println(verifySequenceOfBST(b));
        System.out.println(verifySequenceOfBST1(c));
        System.out.println(verifySequenceOfBST1(d));
    }
}
