public class Solution {
	public ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode next;
		ListNode previous = null;
		while (head != null) {
			// remember the previous next
			next = head.next;
			// reverse
			head.next = previous;
			// remember the reverse
			previous = head;
			// continue process the previous next
			head = next;
		}

		return previous;
	}

	// recursive
	ListNode reverseListInt(ListNode head, ListNode newNode) {
		if (head == null)
			return newNode;
		// next to be head, head to be newNode(next)
		ListNode next = head.next;
		head.next = newNode;
		return reverseListInt(next, head);
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

		System.out.println(new Solution().reverseList(list1));
	}
}
