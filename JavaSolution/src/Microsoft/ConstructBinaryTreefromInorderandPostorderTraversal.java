package Microsoft;

/**
 * Created by xyunpeng on 2/23/16.
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> position = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            position.put(inorder[i], i);
        }
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, position);
    }

    private TreeNode helper(int[] inorder, int istart, int iend, int[] postorder, int pstart, int pend, Map<Integer, Integer> position) {
        if (istart > iend || pstart > pend) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[pend]);
        int p = position.get(postorder[pend]);
        root.left = helper(inorder, istart, p - 1, postorder, pstart, pstart + p - 1 - istart, position);
        root.right = helper(inorder, p + 1, iend, postorder, pstart + p - istart, pend - 1, position);
        return root;
    }
}


//参考了别人家的代码: https://leetcode.com/discuss/10961/my-recursive-java-code-with-o-n-time-and-o-n-space
//其实我也想到了,只是没有用hashmap来空间换时间