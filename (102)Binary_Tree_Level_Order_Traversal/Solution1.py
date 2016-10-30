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

        # Keep track of levels while processing
        current_level = Queue.Queue()
        next_level = Queue.Queue()

        # Start with root
        current_level.put(root)

        while not current_level.empty():
            current = current_level.get()
            # Process current node
            one_level.append(current.val)
            # Store child nodes into next level process queue
            if current.left is not None:
                next_level.put(current.left)
            if current.right is not None:
                next_level.put(current.right)

            # Move to next level when current level completed
            if current_level.empty():
                current_level = next_level
                next_level = Queue.Queue()
                # store current level to final answer
                answer.append(one_level)
                one_level = []

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
