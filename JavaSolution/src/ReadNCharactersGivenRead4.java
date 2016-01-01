/**
 * Created by xyunpeng on 12/31/15.
 */
public class ReadNCharactersGivenRead4 extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */

    //
    public int read(char[] buf, int n) {
        int sum = 0;
        char[] t = new char[4];
        while (sum < n) {
            int res = read4(t);
            if (sum + res > n) {                                    // n不能被4整除,必然会多读一部分出来,这个时候只用拷贝小于等于n的部分
                System.arraycopy(t, 0, buf, sum, n - sum);
                sum = n;
            } else {                                                // 这个是正常情况,
                System.arraycopy(t, 0, buf, sum, res);
                sum += res;
            }
            if (res < 4) break;                                    // 如果发现res比4小,说明文件里面没有可读的了
        }

        return sum;
    }
}
