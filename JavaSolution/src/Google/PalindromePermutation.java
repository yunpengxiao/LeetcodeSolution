package Google;

/**
 * Created by xyunpeng on 3/5/16.
 */
public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        Set<Character> counts = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (!counts.contains(s.charAt(i))) {
                counts.add(s.charAt(i));
            } else {
                counts.remove(s.charAt(i));
            }
        }

        return counts.size() <= 1;

    }
}


//异常简洁的方法