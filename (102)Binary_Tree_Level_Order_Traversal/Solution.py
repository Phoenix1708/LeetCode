import Queue


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
        answer = []
        if root is None:
            return answer

        one_level = []

        q = Queue.Queue()
        # Start with root
        q.put(root)
        # Insert level boundary
        q.put(None)

        while not q.empty():
            current = q.get()

            if current is not None:
                # Store/visit current node
                one_level.append(current.val)
                # Process its children
                if current.left is not None:
                    q.put(current.left)
                if current.right is not None:
                    q.put(current.right)
            else:
                # one level completed
                answer.append(one_level)
                one_level = []
                # Insert level boundary for next level
                # Obviously no next level when all nodes are processed
                if q.qsize() != 0:
                    q.put(None)
        return answer

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
