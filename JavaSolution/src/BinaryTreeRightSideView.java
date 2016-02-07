/**
 * Created by xyunpeng on 2/6/16.
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        int levelLast = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                result.add(levelLast);
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
            } else {
                levelLast = node.val;

                if (null != node.left) {
                    queue.offer(node.left);
                }

                if (null != node.right) {
                    queue.offer(node.right);
                }
            }
        }

        return result;
    }
}


//我的解法其实就是level order traversal + 取最后一个元素
//别人家有更好的解法:  https://leetcode.com/discuss/31348/my-simple-accepted-solution-java