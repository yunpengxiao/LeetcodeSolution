package Microsoft;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by xyunpeng on 1/3/16.
 */
public class ReverseWordsinaString {
    public String reverseWords(String s) {
        if (s.isEmpty()) {
            return "";
        }

        String[] words = s.trim().split(" +");
        /*if (words.length == 0) {
            return "";
        }*/
        for (int i = 0; i < words.length; i++) {
            words[i] = new StringBuilder(words[i]).reverse().toString();
        }

        return new StringBuilder(String.join(" ", words)).reverse().toString();
    }
}


//别人家的代码: https://leetcode.com/discuss/76026/java-short-and-sweet-7-lines