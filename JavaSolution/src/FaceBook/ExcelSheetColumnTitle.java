package FaceBook;

/**
 * Created by xyunpeng on 1/23/16.
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder("");

        while (n > 0) {
            n--;
            result.append((char)('A' + n % 26));
            n /= 26;
        }

        return result.reverse().toString();
    }
}
