package Uber;

/**
 * Created by xyunpeng on 1/23/16.
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int factor = 1;
        int result = 0;
        StringBuilder t = new StringBuilder(s).reverse();
        for (int i = 0; i < t.length(); i++) {
            result += (t.charAt(i) - 'A' + 1) * factor;
            factor *= 26;
        }
        return result;
    }
}
