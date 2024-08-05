public class DeleteNodeLL{
    // Delete node from LL
    // Given a ll and position i, delete the node of ith position from ll iteratively.
    // if position i > length of ll then return same ll without any change
    // indexing starts from index 0 
    // Don't print element, just delete node and return head of updated ll 

    public static Node<Integer> deleteNode(Node<Integer> head, int position){
        if(head == null){
            return head;
        }

        if(position == 0){
            return head.next  // second node
        }
        int count = 0;  // count is basically currPos
        Node<Integer> currNode = head;

        while(currNode != null && count < (position - 1)){
            // We go till pos-1 because we want to land on node that comes just before node to be deleted
            currNode = currNode.next;
            count++;
        }

        if(currNode == null || currNode.next == null){
            return head;
        }
        currNode.next = currNode.next.next;
        return head;
    }
}