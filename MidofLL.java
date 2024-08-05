import java.util.LinkedList;
public class MidofLL{
    public class Node<T>{
        T data;
        Node<T> next;

        public Node(T data){
            this.data = data;
            this.next = next;
        }
    }
    // Using 2 pointer approach
    public static Node<Integer> midPoint(Node<Integer> head){
        // Base Case
        // Single node in linked list
        if(head == null || head.next == null){
            return head;
        }

        // Initially putting slow and fast pointer at head of linked list
        Node<Integer> slow = head;
        Node<Integer> fast = head;

        // fast != null --> case of odd no. of nodes
        // fast.next != null case of even no. of nodes
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next; // takes twice the no. of steps than slow
        }
        return slow;
    }

    public static void main(String args[]){
        Node<Integer> head = takeinput();
        Node<Integer> mid = midpoint(head);
    }
}