package Microsoft;

/**
 * Created by xyunpeng on 2/23/16.
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        helper(root, result);
        return result;
    }

    private void helper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return ;
        }

        helper(root.left, result);
        result.add(root.val);
        helper(root.right, result);
    }

    //非递归版本
    public List<Integer> inorderTraversal0(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode p = root;
        while (p!= null) {
            nodeStack.push(p);
            p = p.left;
        }

        while (!nodeStack.isEmpty()) {
            p = nodeStack.pop();
            result.add(p.val);
            if (p.right != null) {
                nodeStack.push(p.right);
                p = p.right;
                while (p.left != null) {
                    nodeStack.push(p.left);
                    p = p.left;
                }
            }
        }

        return result;
    }
}


//别人家的代码 https://leetcode.com/discuss/19765/iterative-solution-in-java-simple-and-readable