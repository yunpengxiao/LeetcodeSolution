/**
 * Created by xyunpeng on 3/12/16.
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        List<Integer> path = new ArrayList<>();
        path.add(root.val);

        helper(root, target, root.val, path, result);
        return result;
    }

    private void helper(TreeNode root, int target, int sum, List<Integer> path, List<List<Integer>> result) {
        if (target == sum && root.left == null && root.right == null) {
            result.add(new ArrayList<>(path));
            return ;
        }

        if (root.left != null) {
            path.add(root.left.val);
            helper(root.left, target, sum + root.left.val, path, result);
            path.remove(path.size() - 1);
        }

        if (root.right != null) {
            path.add(root.right.val);
            helper(root.right, target, sum + root.right.val, path, result);
            path.remove(path.size() - 1);
        }

    }
}
