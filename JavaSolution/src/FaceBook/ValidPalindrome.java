package FaceBook;

/**
 * Created by xyunpeng on 1/14/16.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }

        StringBuilder t = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i))) {
                t.append(Character.toUpperCase(s.charAt(i)));
            }
        }

        int i = 0;
        int j = t.length() - 1;
        while (i < j) {
            if (t.charAt(i) != t.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
