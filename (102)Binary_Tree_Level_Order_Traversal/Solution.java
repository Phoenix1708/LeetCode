import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        // [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        // TreeNode node5 = new TreeNode(1);
        // TreeNode node6 = new TreeNode(2);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        // node4.left = node5;
        // node4.right = node6;
        System.out.println(levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }
        // Store the values of node at one level
        List<Integer> oneLevel = new ArrayList<>();

        // BFS Queue
        LinkedList<TreeNode> queue = new LinkedList<>();
        // start with root
        queue.offer(root);
        // Insert level boundary
        queue.offer(null);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current != null) {
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
                // Collect the value (not TreeNode object) of current level
                oneLevel.add(current.val);
            } else {
                // One level processing completed
                answer.add(oneLevel);
                oneLevel = new ArrayList<>();
                // Insert level boundary for the next level since the child nodes
                // must have been added into the queue by now. Hence when hitting
                // the boundary we can wrap up one level.
                // Except when all nodes has been processed
                if (queue.size() != 0) {
                    queue.offer(null);
                }
            }
        }
        return answer;
    }
}
