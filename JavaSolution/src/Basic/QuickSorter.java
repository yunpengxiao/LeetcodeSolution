package Basic;

/**
 * Created by xyunpeng on 5/24/16.
 */
public class QuickSorter {
    public void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int start, int end) {
        int mid = partition(nums, start, end);
        quickSort(nums, start, mid);
        quickSort(nums, mid + 1, end);
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int small = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] <= pivot) {
                int tmp = nums[i];
                nums[i] = nums[small];
                nums[small++] = tmp;
            }
        }

        return small - 1;
    }
}
