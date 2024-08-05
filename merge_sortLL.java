public class merge_sortLL{

    public static Node<Integer> mergeSort(Node<Integer> head){
        if(head == null || head.next == null){
            return head;
        }

        Node<Integer> mid = findmid(head);

        // Initializing the head/ starting node of part1 & part2 with head & next node of mid
        Node<Integer> part1 = head;
        Node<Integer> part2 = mid.next;
        mid.next = null;

        // Recursively calling merge sort for both part1 and part2
        part1 = mergeSort(part1);
        part2 = mergeSort(part2);

        Node<Integer> finalHead = merge(part1, part2);
        return finalHead;
    }
    public static Node<Integer> findmid(Node<Integer> head){
        // Base case
        // If linked list is of length 0 or 1 simply return head
        if(head == null || head.next == null){
            return head;
        }
        // 2 Pointer approach for calculating mid
        Node<Integer> slow = head;
        Node<Integer> fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = head.next;
            fast = head.next.next;
        }
        return slow;
    }

    // Code for merging the two lists
    public static Node<Integer> merge(Node<Integer> head1, Node<Integer> head2){
        // Base case
        if(head1 == null){
            return head;
        }
        if(head2 == null){
            return head;
        }

        Node<Integer> newHead = null, newTail = null;

        if(head1.data < head2.data){
            newHead = head1;
            newTail = head1;
            head1 = head1.next;
        } else{
            newHead = head2;
            newTail = head2;
            head2 = head2.next;
        }

        while(head1 != null && head2 != null){
            if(head1.data < head2.data){
                newTail.next = head1;
                newTail = newTail.next;
                head1 = head1.next;
            } else{
                newTail.next = head2;
                newTail = newTail.next;
                head2 = head2.next;
            }
        }

        if(head1 != null){
            newTail.next = head1;
        }
        if(head2 != null){
            newTail.next = head2;
        }
        return newHead;
    }
}