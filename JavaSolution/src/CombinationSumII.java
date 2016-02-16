/**
 * Created by xyunpeng on 2/15/16.
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);
        helper(candidates, target, 0, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private void helper(int[] candidates, int target, int pos, int sum, List<Integer> now, List<List<Integer>> result) {
        if (target < sum) {
            return ;
        } else if (target == sum) {
            result.add(new ArrayList(now));
            return ;
        } else {
            for (int i = pos; i < candidates.length; i++) {
                if (i > pos && candidates[i] == candidates[i - 1]) continue;
                now.add(candidates[i]);
                sum += candidates[i];
                helper(candidates, target, i + 1, sum, now, result);
                now.remove(now.size() - 1);
                sum -= candidates[i];
            }
        }
    }
}
