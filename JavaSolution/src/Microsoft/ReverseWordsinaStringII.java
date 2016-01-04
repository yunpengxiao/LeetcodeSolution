package Microsoft;

/**
 * Created by xyunpeng on 1/3/16.
 */
public class ReverseWordsinaStringII {
    public void reverseWords(char[] s) {
        int start = 0;
        int end = -1;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ' || (i == s.length - 1 && end != -1)) {
                end = (i == s.length - 1? i: i - 1);
                reverse(s, start, end);
                start = i + 1;
            }
        }
        if (end != -1) {
            reverse(s, 0, s.length - 1);
        }
    }

    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            char t = s[end];
            s[end] = s[start];
            s[start] = t;
            start++;
            end--;
        }
    }
}
