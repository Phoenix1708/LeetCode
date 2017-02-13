public class InOrderTraversal {
    TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {
        return isValidBSTree(root);
    }

    // use prev to keep track of where we are in the ascending order / in order traversal
    boolean isValidBSTree(TreeNode current) {
        if (current == null) return true;
        if (!isValidBSTree(current.left)) return false;
        // we've done the left branch, check wherever we left over before returning to current node
        // which could be the left child of current node or the right child of the
        // left child of current node grandchildren etc.
        if (prev != null && prev.val >= current.val) return false;

        // keep track of where we are in the array of ascending order
        prev = current;
        return isValidBSTree(current.right);
    }
}
