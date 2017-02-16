public class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return ans;
        // passing the reference of an array so that when we return from
        // recursive calls we can carry on with whatever was in that array before
        List<Integer> path = new ArrayList<>();
        pathSum(root, sum, path);
        return ans;
    }
    
    public void pathSum(TreeNode root, int sum, List<Integer> currentPath) {
        if (root == null) return;
        
        currentPath.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            // values in current path are saved here
            // currentPath is now free to be modified
            ans.add(new ArrayList(currentPath));
        } else {
            pathSum(root.left, sum - root.val, currentPath);
            pathSum(root.right, sum - root.val, currentPath);
        }
        // if this node complete the path then we need to find more solutions under its parent
        // if this node doesn't complete the path obviously we don't want to add it to the path
        currentPath.remove(currentPath.size() - 1);
    }
}
