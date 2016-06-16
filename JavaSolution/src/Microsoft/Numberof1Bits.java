package Microsoft;

/**
 * Created by xyunpeng on 5/31/16.
 */
public class Numberof1Bits {
    public int hammingWeight(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                result++;
            }
            n >>= 1;
        }

        return result;
    }
}

//这里有个更精简的方法,不过我觉得没什么必要 https://leetcode.com/discuss/27609/short-code-by-time-the-count-and-another-several-method-time
