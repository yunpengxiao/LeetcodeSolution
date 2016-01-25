import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by xyunpeng on 1/24/16.
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] sa = s.toCharArray();
        Arrays.sort(sa);
        char[] ta = t.toCharArray();
        Arrays.sort(ta);
        for (int i = 0; i < s.length(); i++) {
            if (sa[i] != ta[i])
                return false;
        }
        return true;
    }
}
