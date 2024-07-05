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
// Solution 1 -> Brute force approach
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else{
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
    }
}

// Solution 2 :
Brute force approach
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
    public ListNode convertArrToLL(ArrayList<Integer> arr){
        int n = arr.size();
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        for(int i = 0; i < n; i++){
            temp.next = new ListNode(arr.get(i));
            temp = temp.next;
        }
        return dummy.next;
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Brute force approach
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp1 = list1;
        ListNode temp2 = list2;

        while(temp1 != null){
            arr.add(temp1.val);
            temp1 = temp1.next;
        }

        while(temp2 != null){
            arr.add(temp2.val);
            temp2 = temp2.next;
        }

        // Sort the arr
        Collections.sort(arr);
        ListNode head = convertArrToLL(arr);
        return head;
    }
}
