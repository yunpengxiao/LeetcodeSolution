package FaceBook;

/**
 * Created by xyunpeng on 1/15/16.
 */
public class sqrtx {
    //我觉得这题出在面试里面应该考察的是二分法而不是牛顿法,牛顿法更倾向于是一种数学解法而不是算法
    public int mySqrt(int x) {
        if (x < 0) return -1;
        if (x == 0) return 0;

        int left = 1;
        int right = x / 2 + 1;
        int m = 0;
        while (left <= right) {
            m = left + (right - left) / 2;                          //防止溢出
            if (m <= x / m && x / (m + 1) < m + 1) {                //这种方式可以防止溢出
                return m;
            } else if (m  > x / m) {
                right = m - 1;
            } else {
                left = m + 1;
            }
        }

        return m;
    }
}

//没有过多的纠结于这个代码,感觉过多的edge case
//别人家的代码:  http://blog.csdn.net/linhuanmars/article/details/20089131
//别人家的代码:  https://leetcode.com/discuss/77153/straightforward-java-solution