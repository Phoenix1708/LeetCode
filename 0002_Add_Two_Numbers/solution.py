# Definition for singly-linked list.
class ListNode(object):

    def __init__(self, x):
        self.val = x
        self.next = None

    def __str__(self):
        strToPrint = str(self.val)
        valToPrint = self.next
        while valToPrint is not None:
            strToPrint += "->"
            strToPrint += str(valToPrint.val)
            valToPrint = valToPrint.next
        return strToPrint


class Solution(object):

    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        carry = 0
        answer = ListNode(0)

        l1_cp = l1
        l2_cp = l2
        ans_cp = answer

        while l1_cp is not None or l2_cp is not None:

            if l1_cp is not None:
                carry += l1_cp.val
                l1_cp = l1_cp.next

            if l2_cp is not None:
                carry += l2_cp.val
                l2_cp = l2_cp.next

            ans_cp.next = ListNode(carry % 10)
            ans_cp = ans_cp.next
            carry /= 10

        if carry is not 0:
            ans_cp.next = ListNode(carry)

        return answer.next

if __name__ == '__main__':

    d1n1 = ListNode(2)
    d1n2 = ListNode(4)
    d1n3 = ListNode(3)

    d2n1 = ListNode(5)
    d2n2 = ListNode(6)
    d2n3 = ListNode(4)

    d1n1.next = d1n2
    d1n2.next = d1n3

    d2n1.next = d2n2
    d2n2.next = d2n3

    print d1n1
    print d2n1
    print Solution().addTwoNumbers(d1n1, d2n1)
