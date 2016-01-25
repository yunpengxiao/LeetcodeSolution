package FaceBook;

/**
 * Created by xyunpeng on 1/24/16.
 */
public class CountandSay {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        if (n == 2) return "11";
        String result = "11";
        for (int i = 3; i <= n; i++) {
            StringBuilder t = new StringBuilder();
            int count = 0;
            for (int j = 0; j < result.length(); j++) {
                if (j > 0 && result.charAt(j - 1) != result.charAt(j)) {
                    t.append(String.valueOf(count) + result.charAt(j - 1));
                    count = 1;
                } else {
                    count++;
                }
            }
            t.append(String.valueOf(count) + result.charAt(result.length() - 1));
            result = t.toString();
        }
        return result;
    }
}


//题目描述不是很具体,可以看这个链接:  http://www.careercup.com/question?id=4425679
//这种字符串处理的题真是烦, 没什么算法还edge case特别多