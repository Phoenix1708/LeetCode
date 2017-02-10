public class MInMax {
	public static boolean isValidBST(TreeNode root) {

		// hacky way: use Long to solve Int problem

		return root == null || (root.left == null && root.right == null) ||
		       isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	public static boolean isValidBST(TreeNode node, long min, long max) {
		if (node == null) return true;

		// check current node value is in correct range
		return !(node.val <= min || node.val >= max) &&
		        isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
	}
}
