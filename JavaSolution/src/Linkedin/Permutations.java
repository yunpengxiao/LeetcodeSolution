package Linkedin;

/**
 * Created by xyunpeng on 2/14/16.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> path = new ArrayList<>();
        helper(nums, path, result);
        return result;
    }

    private void helper(int[] nums, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) continue;

            List<Integer> t = new ArrayList(path);
            t.add(nums[i]);
            helper(nums, t, result);
        }
    }
}
