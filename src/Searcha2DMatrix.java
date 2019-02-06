public class Searcha2DMatrix {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix.length == 0 || matrix[0].length == 0) return false;
            int row = matrix.length, col = matrix[0].length;
            int l = 0, r = row * col;
            while (l < r) {
                int mid = (l + r) >>> 1;
                int mid_value = matrix[mid / col][mid % col];
                if (mid_value == target) {
                    return true;
                } else if (mid_value < target) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return false;
        }
    }
}
