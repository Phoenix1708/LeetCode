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
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        System.out.println(levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> output = new ArrayList<>();
        List<Integer> currentLevel = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        TreeNode previous = null;
        while (!stack.isEmpty()) {
            TreeNode current = stack.peek();

            if (previous == null || previous.left == current || previous.right == current) {
                if (current.left != null) {
                    stack.push(current.left);
                } else if (current.right != null) {
                    stack.push(current.right);
                } else {
                    stack.pop(); // remove leaf
                    currentLevel.add(current.val);
                }
            } else if (current.left == previous) {
                if (current.right != null) {
                    // add current node to its level
                    currentLevel.add(current.right.val);
                    // Children of current node all processed
                    output.add(currentLevel);
                    currentLevel = new ArrayList<>();
                    // going deep right
                    stack.push(current.right);
                } else {
                    // Post order: no right i.e. right subtree process complete
                    // Process parent
                    stack.pop();
                    currentLevel.add(current.val);
                }
            } else if (current.right == previous) {
                stack.pop();
                currentLevel.add(current.val);
            }

            previous = current;
        }

        return output;
    }
}
