/**
 * Created by xyunpeng on 2/15/16.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);
        helper(candidates, target, new ArrayList<Integer>(), 0, result);
        return result;
    }

    private void helper(int[] candidates, int target, List<Integer> now, int sum, List<List<Integer>> result) {
        if (sum > target) {
            return ;
        } else if (sum == target) {
            result.add(new ArrayList(now));
            return ;
        } else {
            for (int i = 0; i < candidates.length; i++) {
                if (now.size() > 0 && candidates[i] < now.get(now.size() - 1)) continue;
                now.add(candidates[i]);
                sum += candidates[i];
                helper(candidates, target, now, sum, result);
                now.remove(now.size() - 1);
                sum -= candidates[i];
            }
        }
    }
}
