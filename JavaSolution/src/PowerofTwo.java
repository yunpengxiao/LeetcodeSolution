/**
 * Created by xyunpeng on 2/11/16.
 */
public class PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        return ((n & (n-1))==0 && n>0);
    }
}
