public class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0;

    ListNode newHead = new ListNode(0);
    ListNode p1 = l1, p2 = l2, p3 = newHead;

    while (p1 != null || p2 != null) {
      if (p1 != null) {
        carry += p1.val;
        p1 = p1.next;
      }

      if (p2 != null) {
        carry += p2.val;
        p2 = p2.next;
      }

      p3.next = new ListNode(carry % 10);
      p3 = p3.next;
      carry /= 10;
    }

    if (carry == 1)
      p3.next = new ListNode(1);

    return newHead.next;
  }

  public static void main(String[] args) {
    ListNode d1n1 = new ListNode(2);
    ListNode d1n2 = new ListNode(4);
    ListNode d1n3 = new ListNode(3);

    ListNode d2n1 = new ListNode(5);
    ListNode d2n2 = new ListNode(6);
    ListNode d2n3 = new ListNode(4);

    d1n1.next = d1n2;
    d1n2.next = d1n3;

    d2n1.next = d2n2;
    d2n2.next = d2n3;

    System.out.println(d1n1);
    System.out.println(d2n1);

    System.out.println(new Solution().addTwoNumbers(d1n1, d2n1));
  }

}