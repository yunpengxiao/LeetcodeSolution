package FaceBook;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by xyunpeng on 1/29/16.
 */
public class Hindex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = citations.length;
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= h) {
                return h;
            } else {
                h--;
            }
        }
        return h;
    }
}


//这个解法还真是直观...
//https://leetcode.com/discuss/60791/simple-java-solution-with-sort