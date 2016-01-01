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
        for (int i = 0; i <= n / 4; i++) {
            int len = read4(t);
            if (sum + len > n) {
                System.arraycopy(t, 0, buf, sum, n - sum);
                sum = n;
            } else {
                System.arraycopy(t, 0, buf, sum, len);
                sum += len;
            }
        }
        return sum;
    }
}
