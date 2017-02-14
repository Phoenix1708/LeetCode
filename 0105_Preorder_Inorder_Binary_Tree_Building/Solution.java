import java.util.HashMap;
import java.util.Map;

public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return helper(0, 0, inorder.length - 1, preorder, map);
    }

    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, Map<Integer, Integer> map) {
        // end condition
        if (inStart > inEnd) return null;

        // root
        TreeNode root = new TreeNode(preorder[preStart]);

        // index of current root in inorder
        int idx = map.get(root.val);

        root.left = helper(preStart + 1, inStart, idx - 1, preorder, map);
        // idx - inStart + 1 == offset length in inorder
        root.right = helper(preStart + idx - inStart + 1, idx + 1, inEnd, preorder, map);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{7, 10, 4, 3, 2, 8, 11};
        int[] inorder = new int[]{4, 10, 3, 7, 11, 8, 2};
        new PreInOrderTreeBuilding().buildTree(preorder, inorder);
    }
}
