class Solution(object):

    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None:
        	return None

        next = None
        previous = None
        while head is not None:
        	# remember the next
        	next = head.next
        	# reverse
        	head.next = previous
        	# remember the reverse
        	# 'head' has been changed/reversed
        	previous = head
        	# carry on processing the previous next
        	head = next

        return previous
