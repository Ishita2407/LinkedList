/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node pointing to the head of LL
        ListNode start = new ListNode();
        start.next = head;

        // 2 pointers--> slow and fast
        ListNode slow = start;
        ListNode fast = start;

        for(int i=1; i <= n; i++){
            // keep moving the fast pointer till u reach nth node from start
            fast = fast.next;
        }

        // Till the fast pointer reaches null keep moving slow and fast pointer by one step
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        // Removing the previous connection and creating new
        slow.next = slow.next.next;
        return start.next;  // new head of Linkedlist
    }
}
