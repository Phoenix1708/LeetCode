import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

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

        // Keep track of the "node object" at current and next level
        LinkedList<TreeNode> currentLevel = new LinkedList<>();
        LinkedList<TreeNode> nextLevel = new LinkedList<>();
        // start with root
        currentLevel.add(root);

        while (!currentLevel.isEmpty()) {
            TreeNode current = currentLevel.remove();
            if (current.left != null) {
                nextLevel.add(current.left);
            }
            if (current.right != null) {
                nextLevel.add(current.right);
            }
            // Collect the value (not TreeNode object) of current level
            oneLevel.add(current.val);

            // When one level completed
            if (currentLevel.isEmpty()) {
                // Switch/points to next level
                currentLevel = nextLevel;
                nextLevel = new LinkedList<>();
                // add result of current level and reset
                answer.add(oneLevel);
                oneLevel = new ArrayList<>();
            }
        }
        return answer;
    }
}
