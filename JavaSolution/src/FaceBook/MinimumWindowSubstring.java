package FaceBook;

import java.util.HashMap;

/**
 * Created by xyunpeng on 1/4/16.
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }

        HashMap<Character, Integer> needFind = new HashMap<>();
        buildDic(t, needFind);

        int runner, walker = 0;
        int missing = t.length();
        int min = Integer.MAX_VALUE;
        int left = 0, right = 0;
        for (runner = 0; runner < s.length(); runner++) {
            char c = s.charAt(runner);
            if (needFind.containsKey(c)) {
                needFind.put(c, needFind.get(c) - 1);
                if (needFind.get(c) >= 0)                                                     //注意这里的判断,当小于0时表示有很多重复的同一字符
                    missing--;
            }

            while (missing == 0) {
                if (runner - walker + 1 < min) {
                    min = runner - walker + 1;
                    left = walker;
                    right = runner;
                }
                if (needFind.containsKey(s.charAt(walker))) {
                    needFind.put(s.charAt(walker), needFind.get(s.charAt(walker)) + 1);
                    if (needFind.get(s.charAt(walker)) > 0)                                   //同上,得大于1才能表示真正需要++
                        missing++;
                }
                walker++;
            }
        }

        if (min == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(left, right + 1);
    }

    private void buildDic(String t, HashMap<Character, Integer> map) {
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);                          //这是个好函数,不用写if-else了
        }
    }
}

//参考了别人家的代码: https://leetcode.com/discuss/64529/clean-java-sliding-window-solution-with-map
//第一次做这题真的很烦