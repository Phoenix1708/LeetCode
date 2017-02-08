public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        
        TreeLinkNode nextLevelHead = null;
        TreeLinkNode current = null;
        
        while (root != null) {
            // process left child
            if (root.left != null) {
                // if we just entered the new level
                if (nextLevelHead == null) {
                    nextLevelHead = current = root.left;
                } 
                // else we are moving vertically at this level
                // hence we connect the node to the right
                else {
                    current.next = root.left;
                    current = current.next;
                }
            }
            
            if (root.right != null) {
                if (nextLevelHead == null) {
                    nextLevelHead = current = root.right;
                } else {
                    current.next = root.right;
                    current = current.next;
                }
            }
            
            // move vertially
            root = root.next;
            if (root == null) {
                // or move to the next level if current level is done
                root = nextLevelHead;
                nextLevelHead = null;
            }
        }
    }
}
