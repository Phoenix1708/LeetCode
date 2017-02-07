/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return head;
        // link copy with original side by side 
        // and copy the node label (and next)
        RandomListNode iter = head;
        while (iter != null) {
            RandomListNode next = iter.next;
            iter.next = new RandomListNode(iter.label);
            iter.next.next = next;
            iter = next;
        }
        
        // copy random pointer
        iter = head;
        while (iter != null) {
            if (iter.random != null) {
                // "= iter.random.next" link the random pointer of the copy of this node to
                // the "copy" of original node pointed by random pointer i.e. iter.random.next
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }
        
        // restore both list
        iter = head;
        // copy starts from the "next"
        RandomListNode copyHead = head.next;
        
        RandomListNode copyIter = copyHead;
        while (copyIter.next != null) {
            iter.next = iter.next.next;
            iter = iter.next;
            
            copyIter.next = copyIter.next.next;
            copyIter = copyIter.next;
        }
        // break the last link between original and copy
        iter.next = null;
        
        return copyHead;
    }
}
