package Microsoft;

/**
 * Created by xyunpeng on 2/24/16.
 */
public class LargestBSTSubtree {
    public class Result {
        int size;
        int min;
        int max;

        public Result(int size, int min, int max) {
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    int maxSize;

    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        helper(root);
        return maxSize;
    }

    private Result helper(TreeNode root) {
        if (root == null) {
            return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Result left = helper(root.left);
        Result right = helper(root.right);

        if (left.size == -1 || right.size == -1 || root.val <= left.max || root.val >= right.min) {
            return new Result(-1, 0, 0);
        }

        int size = left.size + right.size + 1;
        maxSize = Math.max(size, maxSize);
        return new Result(size, Math.min(left.min, root.val), Math.max(right.max, root.val));
    }
}
