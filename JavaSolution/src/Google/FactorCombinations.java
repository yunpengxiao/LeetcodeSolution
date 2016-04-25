package Google;

/**
 * Created by xyunpeng on 4/24/16.
 */
public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n == 1) {
            return result;
        }
        helper(n, result, new ArrayList<Integer>());
        return result;
    }

    private void helper(int n, List<List<Integer>> result, List<Integer> item) {
        if (n == 1 && item.size() > 1) {
            result.add(new ArrayList(item));
            return ;
        }

        for (int i = 2; i <= n; i++) {
            if (!item.isEmpty() && i < item.get(item.size() - 1)) {
                continue;
            }

            if (n % i == 0){
                item.add(i);
                helper(n / i, result, item);
                item.remove(item.size() - 1);
            }
        }
    }
}
