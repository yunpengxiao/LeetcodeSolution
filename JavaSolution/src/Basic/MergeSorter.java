package Basic;

/**
 * Created by xyunpeng on 5/24/16.
 */
public class MergeSorter {
    public void sort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int start, int end) {
        if (start == end) {
            return ;
        }

        int mid = (end + start) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int[] tmp = new int[end - start + 1];
        int p1 = start;
        int p2 = mid + 1;
        int p = 0;
        while (p1 != mid && p2 != end) {
            if (nums[p1] < nums[p2]) {
                tmp[p++] = nums[p1++];
            } else {
                tmp[p++] = nums[p2++];
            }
        }
        while (p1 != mid) {
            tmp[p++] = nums[p1++];
        }

        while (p2 != end) {
            tmp[p++] = nums[p2++];
        }

        for (int i = 0; i < end - start + 1; i++) {
            nums[start + i] = tmp[i];
        }
    }
}
