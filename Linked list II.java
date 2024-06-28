/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // Base case
        // If LL is empty or LL contains only 1 node it can't contain cycle
        if(head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        ListNode dummy = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){  // cycle exists
                while(dummy != slow){
                    slow = slow.next;
                    dummy = dummy.next;
                }
                return dummy;
            }
        }
        return null;
    }
}
