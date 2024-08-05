import java.util.*;
public class TakeInputLL{
    // O(N^2) ---> Brute force approach
    // O(N) --> Optimized approach
    public static class Node<T>{
        T data;
        Node<T> next;

        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    // Take input and create a linked list till last node -1
    public static Node<Integer> takeInput(){
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        Node<Integer> head = null;
        
        while(data != -1){
            Node<Integer> currNode = new Node<Integer>(data);
            if(head == null){
                head = currNode;
            } else{
                // Tail will refer to the last node 
                Node<Integer> tail = head;
                while(tail.next != null){
                    tail = tail.next;
                }
                // Now currNode will be connected after the last node , so it will become the last node
                tail.next = currNode;
            }
            data = sc.nextInt();
        }
        return head;
    }

    // Time complexity - O(N)
    public static Node<Integer> takeInputOptimized(){
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        Node<Integer> head = null, tail = null;
        while(data != -1){
            Node<Integer> currNode = new Node<Integer>(data);
            // Make single node head and tail both
            if(head == null){
                head = currNode;
                tail = currNode;
            } else {
                // When an element is already present
                tail.next = currNode;
                tail = currNode;  // currNode is now the last node of LL
            }
        }
    }

    public static void main(String args[]){
        Node<Integer> head = takeInput();
    }
}