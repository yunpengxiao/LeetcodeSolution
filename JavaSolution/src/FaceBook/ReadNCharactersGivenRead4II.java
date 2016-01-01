package FaceBook;

/**
 * Created by xyunpeng on 12/31/15.
 */
public class ReadNCharactersGivenRead4II {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private char[] t = new char[4];
    private int tptr = 0;
    private int tcnt = 0;
    public int read(char[] buf, int n) {
        int sum = 0;

        if (tptr != 0) {                                            //检查一下有没有上次没用完的t
            if (tcnt > n) {
                System.arraycopy(t, tptr, buf, 0, n);
                tptr = tptr + n;
                tcnt -= n;
                sum = n;
            } else {
                System.arraycopy(t, tptr, buf, 0, tcnt);
                tptr = 0;
                sum += tcnt;
                tcnt = 0;
            }
        }

        while (sum < n) {
            int res = read4(t);
            if (sum + res > n) {                                    // n不能被4整除,必然会多读一部分出来,这个时候只用拷贝小于等于n的部分
                System.arraycopy(t, 0, buf, sum, n - sum);
                tptr = n - sum;                                     // 在读取多次时,这个时候可能多读了一部分,需要存下来供下次使用
                tcnt = res - tptr;
                sum = n;
            } else {                                                // 这个是正常情况,
                System.arraycopy(t, 0, buf, sum, res);
                sum += res;
            }
            if (res < 4) break;                                    // 如果发现res比4小,说明文件里面没有可读的了
        }

        return sum;
    }

    //别人家的解答 https://leetcode.com/discuss/21219/a-simple-java-code
}

