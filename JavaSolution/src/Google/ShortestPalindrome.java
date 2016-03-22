package Google;

/**
 * Created by xyunpeng on 3/20/16.
 */
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        int i = 0;
        int end = s.length() - 1;
        int j = end;
        char chs[] = s.toCharArray();                     //这里不用char的数组就会超时,我想这题本身是想卡KMP
        while (i < j){
            if (chs[i] == chs[j]) {
                i++;
                j--;
            } else {
                i = 0;
                end--;
                j = end;
            }
        }

        return new StringBuilder(s.substring(end + 1)).reverse().toString() + s;
    }
}


//这题原意应该是想让人用KMP来解的
//参考了: https://leetcode.com/discuss/61416/my-9-lines-three-pointers-java-solution-with-explanation