class TreeNode(object):
    """
    Definition for a binary tree node.
    """

    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):

    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if not root:
            return []
        
        answer = list()
        one_level = []

        current_level = [root]
        while current_level:
            next_level = list()
            for n in current_level:
                one_level.append(n.val)
                if n.left: next_level.append(n.left)
                if n.right: next_level.append(n.right)
            answer.append(current_level)
            current_level = next_level

#######################
# Test
#######################
root = TreeNode(3)
node1 = TreeNode(9)
node2 = TreeNode(20)
node3 = TreeNode(15)
node4 = TreeNode(7)
# node5 = new TreeNode(1);
# node6 = new TreeNode(2);
root.left = node1
root.right = node2
node2.left = node3
node2.right = node4
# node4.left = node5;
# node4.right = node6;
print Solution().levelOrder(root)