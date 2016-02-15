package Microsoft;

/**
 * Created by xyunpeng on 2/14/16.
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] versions1 = version1.split("\\.");
        String[] versions2 = version2.split("\\.");

        int m = versions1.length;
        int n = versions2.length;
        int i = 0;
        while (i < m || i < n) {
            int v1 = Integer.parseInt(i < m? versions1[i]: "0");
            int v2 = Integer.parseInt(i < n? versions2[i]: "0");
            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            }
            i++;
        }
        return 0;
    }
}
