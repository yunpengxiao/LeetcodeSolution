/**
 * Created by xyunpeng on 1/20/16.
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;        //一定的这样才能过case
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;                                   //为什么这儿只需要return start?
    }
}
