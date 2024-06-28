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
    public static ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode Next = head.next;
            head.next = prev;
            prev = head;
            head = Next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        // If LL is empty or has a single element it is palindrome
        if(head == null || head.next == null) return true;

        // step1 : find the middle of LL
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the second half of LL
        slow.next = reverse(slow.next);
        slow = slow.next;
        ListNode dummy = head;

        while(slow!=null) {
            if(dummy.val != slow.val) return false;
            dummy = dummy.next;
            slow = slow.next;
        }
        return true;
    }
}
