package Google;

/**
 * Created by xyunpeng on 3/2/16.
 */
public class PaintFence {
    public int numWays(int n, int k) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return k;
        }

        int same = k;
        int diff = k * (k - 1);


        for (int i = 2; i < n; i++) {
            int temp = same;
            same = diff;
            diff = diff * (k - 1) + temp * (k - 1);
        }

        return same + diff;
    }
}
