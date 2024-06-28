/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // Copying the value of next node into curr node to be deleted
        node.val = node.next.val;
        node.next = node.next.next; // changing connection
    }
}
