package Linkedin;

/**
 * Created by xyunpeng on 2/14/16.
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        boolean[] added = new boolean[nums.length];
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, path, added, result);
        return result;
    }

    private void helper(int[] nums, List<Integer> path, boolean[] added, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList(path));
            return ;
        }

        for (int i = 0; i < nums.length; i++) {
            if (added[i]) continue;
            if (i > 0 && !added[i - 1] && nums[i] == nums[i - 1]) continue;     //when a number has the same value with its previous, we can use this number only if his previous is used
            //ArrayList<Integer> t = new ArrayList(path);
            path.add(nums[i]);
            added[i] = true;
            helper(nums, path, added, result);
            added[i] = false;
            path.remove(path.size() - 1);
        }
    }
}

//参考 https://leetcode.com/discuss/73856/really-easy-solution-easier-than-solutions-with-very-high-vote