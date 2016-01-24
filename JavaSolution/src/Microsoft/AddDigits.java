package Microsoft;

/**
 * Created by xyunpeng on 1/23/16.
 */
public class AddDigits {
    public int addDigits(int num) {
        if (num == 0) return num;
        else
            return num - 9 * ((num - 1) / 9);
    }
}

//纯数学...
//也许这样写更易懂   https://leetcode.com/discuss/80037/java-one-line-simple-answer