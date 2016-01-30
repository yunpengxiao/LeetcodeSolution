package FaceBook;

/**
 * Created by xyunpeng on 1/29/16.
 */
public class HindexII {
    public int hIndex(int[] citations) {
        if (citations.length == 0) return 0;
        int left = 0;
        int right = citations.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (citations[mid] == (citations.length - mid)) {
                return citations[mid];
            } else if (citations[mid] > (citations.length - mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return citations.length - right - 1;
    }
}
