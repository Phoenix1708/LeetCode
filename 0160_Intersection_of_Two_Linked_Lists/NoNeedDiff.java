public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // boundary check
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        // until they are the same or both null
        while(a != b) {
            // for the end of first iteration,
            // we just reset the pointer to the head of another linked list
            // i.e. Use two pointers to remove the diff
            // You can prove that: say A length = a + c, B length = b + c,
            // after switching pointer, pointer A will move another b + c steps,
            // pointer B will move a + c more steps,
            // since (a + c + b) + c = (b + c + a) + c, it does not matter what value c is.
            // Pointer A and B must meet after a + c + b (b + c + a) steps. If c == 0, they meet at NULL.
            //     * * *
            // * * * * *
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }
        return a;
    }

    public static void main(String[] args) {

        // creating first linked list
        ListNode six = new ListNode(6);
        ListNode seven = new ListNode(7);
        ListNode fifteen = new ListNode(15);
        ListNode thirteen = new ListNode(30);

        ListNode list1 = new ListNode(3);
        list1.next = six;
        list1.next.next = seven;
        list1.next.next.next = fifteen;
        list1.next.next.next.next = thirteen;

        // creating second linked list
        ListNode list2 = new ListNode(10);
        list2.next = fifteen;
        list2.next.next = thirteen;

        System.out.println("The node of intersection is " +
                new Solution().getIntersectionNode(list1, list2));
    }
}
