package FaceBook;

/**
 * Created by xyunpeng on 1/15/16.
 */
public class Powxn {
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        double half = myPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else if (n > 0){
            return half * half * x;
        } else {
            return half * half / x;           //注意这里其实不用分太多的情况考虑, 因为x = 1的时候会自动返回 1 / x
        }
    }
}

//别人家的代码: http://blog.csdn.net/linhuanmars/article/details/20092829