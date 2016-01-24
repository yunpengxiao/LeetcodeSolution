package FaceBook;

/**
 * Created by xyunpeng on 1/23/16.
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return ;
        int p = m + n - 1;
        int p1 = m - 1;
        int p2 = n - 1;
        while (p >= 0 && p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p--] = nums1[p1--];
            } else {
                nums1[p--] = nums2[p2--];
            }
        }

        if (p1 < 0) {
            while (p2 >= 0) {
                nums1[p2] = nums2[p2];
                p2--;
            }
        }
    }
}
