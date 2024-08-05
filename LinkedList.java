public class LinkedList{
    public static class Node{
        int data;
        Node next;  // points to next node in the linked list -- > reference

        public Node(int data){
            this.data = data;
            this.next = null;
        }

        // Head Node - first node of linked list
        // Tail Node - last node of Linked list
    }
    public static Node head;
    public static Node tail;
    public static int size;

    // Creating a node class with generics
    public class Node<T>{
        T data;
        Node <T> next;
        
        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(int data){   // O(1) constant time 
        // Step 1 - create new Node
        Node newNode = new Node(data);   
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

    public void AddinMiddle(int idx, int data){  // Linear time O(n)
        // Time is taken to find/ track the index
        // Linkages will be done in constant time - O(1)

        if(idx == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while(i < idx-1){
            temp = temp.next;
            i++;
        }

        // i = idx-1; temp -> prev
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst(){
        if(size == 0){
            System.out.println("Linked list is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast(){
        if(size == 0){
            System.out.println("Linked list is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        // Prev - i = size-2 ; last = size - 1/(n-1)
        Node prev = head;
        for(int i=0; i<size-2; i++){
            prev = prev.next;
        }
        int val = prev.next.data; // tail data is stored
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int itrSearch(int key){   // O(n) Iterative search
        Node temp = head;
        int i = 0;
        while(temp != null){
            if(temp.data == key){  // key found
                return i;
            }
            temp = temp.next;
            i++;
        }
        // key not found
        return -1;
    }
    public int helper(Node head, int key){  // TC: O(n) Sc:O(n)
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx == -1){
            return -1;
        }
        return idx+1;
    }
    public int recSearch(int key){
        return helper(head,key);
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

    public void reverse(){
        Node prev = null;
        Node curr = tail = head;   // assignment is always right to left, so head ki value first goes to tail then tail ki value curr mai
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    

    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        ll.print();
        // ll.head = new Node(1);
        // ll.head.next = new Node(2);
        ll.addFirst(2);
        ll.print();
        ll.addFirst(1);
        ll.print();
        ll.addLast(3);
        ll.print();
        ll.addLast(4);
        ll.print();
        ll.AddinMiddle(2,9);
        ll.print();
        System.out.println("Size of linked list is:" + ll.size);
        ll.removeFirst();
        ll.print();
        ll.removeLast();
        ll.print();
        System.out.println("Finally size of LL is: " + ll.size);
        System.out.println(ll.recSearch(3));
        System.out.println(ll.recSearch(10));
        ll.reverse();
        System.out.println("Reversed linked list is:");
        ll.print();

        // Creting a new node 
        Node<Integer> n1 = new Node<>(10);
        System.out.println(n1.data)  // 10
        System.out.println(n1.next) // null -> next value for a node is by default null
    }
}

// Methods can be made to perform certain tasks
    /* add()  ---> add First / add Last
    remove()
    print()
    search()  */

/* Add First - 1) create new node 
               2) New node's next = head
               3) head = new Node
  */

/*  Add Last - 1) Create a node ( newNode )
               2) tail.next = newNode 
               3) tail = newNode
 
 */

/*  PRINT LINKED LIST - 1) Node temp = head;
                           while(temp != null){
                        2) print (temp.data)
                        3) temp = temp.next
                           }
*/

// Add in middle
/* add(index,data)
1) newNode.next = temp.next
2) temp.next = newNode
 
*/

// Size of Linked list - create static variable initialized with 1 , when new node is added size++, remove size--

// Remove first - head will be deleted by garbage collector , second node will be made head

// Remove last - tail ke prev ko tail bna do , usko point krwado null pr
// Search (iterative) - search for a key in LL . return position where it is found . if not found return -1
/* Node temp = head
   while (temp != NULL){
    check(temp.data = key ?)
     idx++
     found ? print
     temp == null - return -1 that key doesn't exists
   }
 */

 // Search recursively - phehele head ko chodke baaki elements/ nodes pr check kro ki kya key exist krti h ? if yes print else 
 // head se pucho kya head se key match hoti h?
 // as soon as at each level the ll size decreases and becomes null 
 // Base case- when head = null ; return -1