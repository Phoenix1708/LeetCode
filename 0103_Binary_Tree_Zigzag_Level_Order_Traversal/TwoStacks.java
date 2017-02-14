public class TwoStacks {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        
        List<List<Integer>> answer = new ArrayList<>();
        if (root != null) s1.push(root);
        
        while (!s1.isEmpty() || !s2.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            while (!s1.isEmpty()) {
                TreeNode n = s1.pop();
                level.add(n.val);
                if (n.left != null) s2.push(n.left);
                if (n.right != null) s2.push(n.right);
            }
            answer.add(level);
            
            level = new ArrayList<>();
            while (!s2.isEmpty()) {
                TreeNode n = s2.pop();
                level.add(n.val);
                if (n.right != null) s1.push(n.right);
                if (n.left != null) s1.push(n.left);
            }
            // in case nothing in s2 when we reach bottom level
            if (!level.isEmpty()) answer.add(level);
        }
        return answer;
    }
}
