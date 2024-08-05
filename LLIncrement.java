import java.util.LinkedList;
public class LLIncrement{

    // Generic Node
    public static class Node<T>{
        T data;
        Node<T> next;

        Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node<Integer> createLinkedList(){
        // Creating a new node 
        // Node n4 = new Node(10);  // n1 = reference Node n1;
        Node<Integer> n1 = new Node<>(10);
        Node<Integer> n2 = new Node<>(20);
        Node<Integer> n3 = new Node<>(30);
        Node<Integer> n4 = new Node<>(40);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;
        return n1;
    }

    public static void print(Node<Integer> head){

        // System.out.println(head.data);
        // Syso(head.next.data);
        // Syso(head.next.next.data);
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static int length(Node<Integer> head){
        Node<Integer> temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    public static void increment(Node<Integer> head){
        head.data++;
    }

    // To increment the linked list
    public static void IncrementAll(Node<Integer> head){
        Node<Integer> temp = head;
        while (temp != null){
            temp.data++;
            temp = temp.next;
            // 11 21 31
        }
    }

    public static void main(String a[]){
        Node<Integer> head = createLinkedList();  // 11 20 30
        increment(head);
        System.out.println("Only head is incremented");
        print(head);
        IncrementAll(head);
        System.out.println("All the nodes are incremented");
        print(head);
        System.out.println(length(head));

    }
}