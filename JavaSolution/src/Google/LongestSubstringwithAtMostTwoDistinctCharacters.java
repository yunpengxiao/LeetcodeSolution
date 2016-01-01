package Google;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by xyunpeng on 1/1/16.
 */
public class LongestSubstringwithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() < 3) {
            return s.length();
        }

        HashMap<Character, Integer> map = new HashMap<>();

        int max = 0;
        int walker = 0;
        int runner = 0;
        while (runner < s.length()) {
            if (map.containsKey(s.charAt(runner)) || map.size() < 2) {                      //如果以前已经出现过,把map里面的index值更新为最近出现的那个
                map.put(s.charAt(runner), runner);
            } else {                                                                        //这里是出现了第三个字母, walker应该更新为离runner最近的那个字母的位置
                max = Math.max(max, runner - walker);
                int index1 = map.get(s.charAt(walker));
                int index2 = map.get(getOtherChar(map, s.charAt(walker)));
                if (index1 > index2) {
                    map.remove(getOtherChar(map, s.charAt(walker)));
                    walker = index2 + 1;                                                    //注意这里是index2 + 1, 而不是index1,因为index1已经被更新成了这个字母最后一次出现的位置
                } else {
                    map.remove(s.charAt(walker));
                    walker = index1 + 1;                                                    //注意这里是index1 + 1, 而不是index2,因为index2已经被更新成了这个字母最后一次出现的位置
                }
                map.put(s.charAt(runner), runner);                                          //这里可以优化,因为无论有没有出现过runner都必须放进map
            }
            runner++;
        }
        max = Math.max(max, runner - walker);
        return max;
    }

    //找到map里的另一个字符, 这个方法很蠢但是我想不出别的办法了,
    private char getOtherChar(HashMap<Character, Integer> map, char c) {
        for (Character t : map.keySet()) {
            if (c != t) {
                return t;
            }
        }
    }
}

//别人家的代码 http://www.danielbit.com/blog/puzzle/leetcode/leetcode-longest-substring-with-at-most-two-distinct-characters
//别人家的代码 https://leetcode.com/discuss/74055/4ms-java-two-pointers-solution-beat-100%25
//这里面有很多 https://leetcode.com/discuss/questions/oj/longest-substring-with-at-most-two-distinct-characters