/**
 * Created by xyunpeng on 4/24/16.
 */
public class PowerofFour {
    public boolean isPowerOfFour(int num) {
        return (num > 0) && (num & (num - 1)) == 0 && (num & 0x55555555) == num;
    }
}

//别人家的解说: https://segmentfault.com/a/1190000003481153