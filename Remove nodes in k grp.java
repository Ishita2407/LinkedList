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
    public static int countLength(ListNode head){
        ListNode temp = head;
        int length = 0;
        while(temp != null){
            length++;
            temp = temp.next;
        }
        return length;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        // Create a dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Calculate length of LL
        int length = countLength(head);

        ListNode prev = dummy;
        ListNode curr;
        ListNode nex;

        while(length >= k){
            curr = prev.next;
            nex = curr.next;

            for(int i=1; i<k; i++){
                curr.next = nex.next;
                nex.next =  prev.next;
                prev.next = nex;
                nex = curr.next;
            }
            prev = curr;
            length -= k;
        }
        return dummy.next;
    }
}
