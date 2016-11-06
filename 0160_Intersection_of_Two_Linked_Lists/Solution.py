import gc

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """

        a = headA
        b = headB

        if a is None or b is None:
            return None

        while a != b:
            a = headB if a is None else a.next
            b = headA if b is None else b.next
        
        # clean the memory
        gc.collect()
        return a
