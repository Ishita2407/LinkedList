import java.util.LinkedList;
public class InsertNodeInLL{
    public static Node<Integer> insert(Node<Integer> head, int pos, int data){
        Node<Integer> n = new Node<Integer>(data);

        int currPos = 0;
        if(pos == 0){
            // Insertion at first index
            n.next = head;
            head = n;
            return head;
        }

        Node<Integer> prev = head;
        while(prev != null && currPos < (pos - 1)){
            currPos++;
            prev = prev.next;
        }

        if(prev == null){
            return head;
        }

        n.next = prev.next;
        prev.next = n;
        return head;

    }

    public static void main(String args[]){
        Node<Integer> head = takeInput();
        insert(head, 80, 0);
        print(head);
    }
}