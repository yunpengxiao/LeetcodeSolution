package FaceBook;

/**
 * Created by xyunpeng on 1/18/16.
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        if (needle == null || haystack == null) {
            return  -1;
        }
        int hlength = haystack.length();
        int nlength = needle.length();
        for (int i = 0; i <= hlength - nlength; i++) {
            if (haystack.substring(i, i + nlength).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
