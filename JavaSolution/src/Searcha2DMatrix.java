/**
 * Created by xyunpeng on 2/3/16.
 */
public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix[0].length;
        int start = 0;
        int end = matrix.length * m - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + ((end - start) >> 1);
            int t = matrix[mid / m][mid % m];
            if (t == target) {
                return true;
            } else if ( t < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (matrix[start / m][start % m] == target) {
            return true;
        }

        if (matrix[end / m][end % m] == target) {
            return true;
        }

        return false;
    }
}
