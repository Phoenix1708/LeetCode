public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        // this is actually BFS but using pointer
        while (root.left != null) {
            TreeLinkNode iter = root;
            while (iter != null && iter.left != null) {
                // assign right to be the next of left
                // within the same subtree
                iter.left.next = iter.right;
                // assign the next of right to be the left of the next of parent
                iter.right.next = (iter.next == null) ? null : iter.next.left;
                // move vertically to finish this level i.e. BFS
                iter = iter.next;
            }
            // go to next level
            root = root.left;
        }
    }
}
