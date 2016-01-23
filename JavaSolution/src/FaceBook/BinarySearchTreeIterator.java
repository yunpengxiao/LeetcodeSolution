package FaceBook;

import java.util.Stack;

/**
 * Created by xyunpeng on 1/22/16.
 */
public class BinarySearchTreeIterator {

    Stack<TreeNode> path;

    public BinarySearchTreeIterator(TreeNode root) {
        path = new Stack<TreeNode>();
        push(root);
    }

    public boolean hasNext() {
        return !path.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = path.pop();
        int result = node.val;
        push(node.right);
        return result;
    }

    private void push(TreeNode root) {
        while (root != null) {
            path.push(root);
            root = root.left;
        }
    }
}


//参考了 https://leetcode.com/discuss/67872/very-concise-solution-by-using-stack-in-java