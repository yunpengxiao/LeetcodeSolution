/**
 * Created by xyunpeng on 1/22/16.
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n < 2) return n;
        int step1 = 1;
        int step2 = 1;
        for (int i = 2; i <=n; i++) {
            int t = step2;
            step2 = step2 + step1;
            step1 = t;
        }
        return step2;
    }
}
