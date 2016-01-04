package FaceBook;

/**
 * Created by xyunpeng on 1/1/16.
 */
public class OneEditDistance {
    //不是最简洁的代码,但是我觉得这样写比较好懂,也比较好和面试官讲清楚
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m > n) {
            return isOneEditDistance(t, s);
        }

        if (n - m > 1) {
            return false;
        }

        for (int i = 0; i < m; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (m == n) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else {
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }
        return m != n;                                                          //此时应该是for循环里没有碰见不一样的,所以只有可能是这俩字符串完全相等(返回false),或者t比s正好就多最后一个元素(返回true)
    }
}
