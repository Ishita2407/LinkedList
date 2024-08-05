public class MergeSortLL{
    // APPLYING MERGE SORT ON LINKED LIST
    // TIME COMPLEXITY - O(nlogn)
    // 2 pointer approach
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    private Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;   // mid node
    }
    private Node merge(Node head1, Node head2){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;
        while(head != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedLL.next;
    }

    public Node mergeSort(Node head){
        // Divide n conquer - merge sort 
        //Base case
        // When linked list has only 1 element/ is empty then it is already sorted
        if(head == null || head.next == null){
            return head;
        }
        
        // Find mid
        Node mid = getMid(head);

        // left & right half ke liyeh MS
        Node rightHead = mid.next;
        mid.next = null;
        Node newleft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // merge
        return merge(newleft, newRight);
    }
    public void addFirst(int data){   // O(1) constant time 
        // Step 1 - create new Node
        Node newNode = new Node(data);   // Constructor
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }

        // Step 2 - newNode next = head
        newNode.next = head;   // link - newNode has address the address of that node

        // Step 3 - head = newNode
        head = newNode;
    }

    public void addLast(int data){  // O(1) constant time
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }
    public void print(){   // Linear time complexity O(n)
        if(head == null){
            System.out.println("Linked list is Empty");
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println(" null");
    }
    public static void main(String args[]){
        MergeSortLL ll = new MergeSortLL();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        // 5 -> 4 -> 3 -> 2 -> 1
        ll.print();
        ll.head = ll.mergeSort(ll.head);
        ll.print();
    }
}