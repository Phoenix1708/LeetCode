public class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }

  @Override
  public String toString() {
    String strToPrint = String.valueOf(val);
    ListNode valToPrint = next;
    while (valToPrint != null) {
      strToPrint += "->";
      strToPrint += valToPrint.val;
      valToPrint = valToPrint.next;
    }
    return strToPrint;
  }
}