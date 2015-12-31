import java.util.HashMap;

/**
 * Created by xyunpeng on 12/30/15.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    // 这个复杂度O(n^2)
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++)
            if (!map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), j);
            } else {
                max = j - i > max? j - i: max;
                i = map.get(s.charAt(j));       //把i设置为上一个出现的地方,下次就不用从上个i+1的地方开始搜了
                map.clear();
                break;
            }
            if (!map.isEmpty()) {
                max = s.length() - i > max? s.length() - i: max;
            }
        }
        return max;
    }

    //复杂度O(n)
    public int lengthOfLongestSubstring2(String s) {
        if (s == null) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            if (!map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), right);
            } else {
                map.put(s.charAt(right), right);
                max = Math.max(max, right - left);
                while (s.charAt(left) != s.charAt(right)) {
                    map.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
            right++;
        }
        return Math.max(max, right - left);
    }
}
