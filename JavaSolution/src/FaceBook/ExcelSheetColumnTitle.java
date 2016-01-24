package FaceBook;

/**
 * Created by xyunpeng on 1/23/16.
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while (n-- > 0) {
            result.append((char)(n % 26 + 'A'));
            n = n / 26;
        }
        if (n == 0) return "A";
        else return result.reverse().toString();
    }
}
