package Linkedin;

/**
 * Created by xyunpeng on 2/6/16.
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        List<Integer> level = new ArrayList<>();
        boolean reverse = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                if (reverse) {
                    Collections.reverse(level);
                }
                reverse = !reverse;
                result.add(level);
                level = new ArrayList<>();
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
            } else {
                level.add(node.val);

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
