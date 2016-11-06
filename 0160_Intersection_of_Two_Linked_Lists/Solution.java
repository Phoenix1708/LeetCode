public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLength = getLength(headA);
        int bLength = getLength(headB);

        if (aLength > bLength) {
            int diff = aLength - bLength;
            return getIntersection(headA, headB, diff);
        } else {
            int diff = bLength - aLength;
            return getIntersection(headB, headA, diff);
        }
    }

    ListNode getIntersection(ListNode bigger, ListNode smaller, int diff) {
        // advance the bigger list to the end of diff
        int count = 0;
        while (count <= diff) {
            bigger = bigger.next;
            if (bigger == null){
                return null;
            }
            count++;
        }
        while (bigger != null && smaller != null) {
            if (bigger == smaller) {
                return bigger;
            }
            bigger = bigger.next;
            smaller = smaller.next;
        }

        return null;
    }

    int getLength(ListNode node) {
        int count = 0;
        while (node != null) {
            node = node.next;
        }
        return count;
    }
}