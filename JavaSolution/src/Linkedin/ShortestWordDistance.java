package Linkedin;

/**
 * Created by xyunpeng on 1/1/16.
 */
public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int index1 = -1, index2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                index1 = i;
            } else if (words[i].equals(word2)) {
                index2 = i;
            } else {
                continue;
            }
            if (index1 != -1 && index2 != -1) {
                min = Math.min(min, Math.abs(index1 - index2));
            }
        }
        return min;
    }
}

//别人家的代码: https://leetcode.com/discuss/61820/java-only-need-to-keep-one-index