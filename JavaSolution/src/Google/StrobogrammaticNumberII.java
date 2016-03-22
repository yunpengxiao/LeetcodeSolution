package Google;

/**
 * Created by xyunpeng on 3/21/16.
 */
public class StrobogrammaticNumberII {
    List<String> result = new ArrayList<>();

    public List<String> findStrobogrammatic(int n) {
        helper(new char[n], 0, n - 1);
        return result;
    }

    private void helper(char[] path, int start, int end) {
        if (start > end) {
            result.add(new String(path));
        } else if (start == end) {
            path[start] = '1';
            helper(path, start + 1, end - 1);
            path[start] = '0';
            helper(path, start + 1, end - 1);
            path[start] = '8';
            helper(path, start + 1, end - 1);
        } else {
            if (start != 0) {
                path[start] = '0';
                path[end] = '0';
                helper(path, start + 1, end - 1);
            }
            path[start] = '1';
            path[end] = '1';
            helper(path, start + 1, end - 1);
            path[start] = '6';
            path[end] = '9';
            helper(path, start + 1, end - 1);
            path[start] = '8';
            path[end] = '8';
            helper(path, start + 1, end - 1);
            path[start] = '9';
            path[end] = '6';
            helper(path, start + 1, end - 1);
        }
    }
}
