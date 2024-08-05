import java.util.*;
public class PrintIthNodeLL{
    // O(N^2)
    public static class Node<T>{
        T data;
        Node<T> next;

        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    public static void printIthNode(Node<Integer> head, int i){
        int position = 0;

        Node<Integer> temp = head;
        while(temp != null && position < i){
            temp = temp.next;
            position++;
        }

        if(temp != null){
            System.out.println(temp.data + " ");
        }
    }

    public static void main(String args[]){
        Node<Integer> head = takeInput();
    }
}