package Google;

/**
 * Created by xyunpeng on 2/11/16.
 */
public class PowerofThree {
    public boolean isPowerOfThree(int n) {
        return n > 0 && (1162261467 % n == 0);
    }
}
