public class InsertRecursivelyLL{
    public static Node<Integer> InsertRec(Node<Integer> head, int element, int position){
        if(head == null && position > 0){
            return head;
        }
        
        if(position == 0){
            Node<Integer> newNode = new Node<>(element);
            newNode.next = head;
            return newNode;
        } else {
            // Ask recursion to insert in smaller list
            Node<Integer> smallHead = InsertRec(head.next, element, position-1);
            head.next = smallHead;
            return head;
        }

        public static Node<Integer> deleteRec(Node<Integer> head, int position){
            if(head == null){
                return head;
            }
            if(position >= len(ll)){
                throw Exception("Position out of bounds");
            }
            if(position == 0){
                return head.next;   // 1st node deleted successfully
            } else {
                Node<Integer> smallhead = deleteRec(head.next, position-1);
                head.next = smallhead;
                return head;
            }  
        }
    }
}