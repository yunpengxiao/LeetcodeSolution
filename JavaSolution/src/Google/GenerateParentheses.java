package Google;

/**
 * Created by xyunpeng on 2/14/16.
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        helper(n, n, "", result);
        return result;
    }

    private void helper(int right, int left, String path, List<String> result) {
        if (right > left || right < 0 || left < 0) return ;
        if (right == 0 && left == 0) {
            result.add(path);
            return ;
        }

        helper(right - 1, left, path + '(', result);
        helper(right, left - 1, path + ')', result);
    }
}


//这题居然是我自己想出来的 好牛逼