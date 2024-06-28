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
    public boolean hasCycle(ListNode head) {
        // Pointers slow and fast are initially placed at head
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            // slow pointer has step size of 1
            slow = slow.next;
            fast = fast.next.next;   // fast pointer has step size of 2
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}


soln 2
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
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
