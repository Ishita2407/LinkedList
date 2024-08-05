public class RevLL{
    // Time complexity - O(n^2)
    // Space complexity - O(n)
    // n is size of singly linked list
    // Approach 1 
    public static Node<Integer> reverse(Node<Integer> head){
        // Base case 
        // When the linked list has no node / only 1 node
        if(head == null && head.next == null){
            return head;
        }
        // smallhead = head of small list ie tail of bigger original list 
        Node<Integer> smallhead = reverse(head.next);
        Node<Integer> tail = smallhead;
        while(tail.next != null){
            tail = tail.next;
        }
        tail.next = head;
        head.next = null;
        return smallhead;
    }

    // Reverse pair 
    // Approach 2
    // Recursion will give us both head and tail of the list
    public class DoubleNode{
        // Object of this class will have both head and tail
        Node<Integer> head;
        Node<Integer> tail;
        DoubleNode(){
        }

        DoubleNode(Node<Integer> head, Node<Integer> tail){
            this.head = head;
            this.tail = tail;
        }
    }
    public static DoubleNode revereseOptimized(Node<Integer> head){
        DoubleNode ans; // reference
        // Base case
        if(head == null && head.next == null){
            ans = new DoubleNode();
            ans.head = head;
            ans.tail = head;
            return ans;
        }

        // Recursion
        // This doubleNode will have both head and tail of reversed linked list
        DoubleNode<Integer> smallhead2 = revereseOptimized(head.next);
        smallhead2.tail.next = head;
        head.next = null;
        ans = new DoubleNode();  // constructor
        ans.head = smallhead2.head;
        ans.tail = head;
        return ans;
    }


    // Time complexity - O(n)
    public static Node<Integer> RevRecursiveBest(Node<Integer> head){
        if(head == null && head.next == null){
            return  head ;
        }
        Node <Integer> smallhead = RevRecursiveBest(head.next);
        Node<Integer> reversedTail = head.next;  // head.next = head of smaller problem
        reversedTail.next = head;  // 1 <-- 2 <-- 3 < -- 4
        head.next = null // null <--- 1 <-- 2 <-- 3 <-- 4
        return smallhead;
    }
    
}