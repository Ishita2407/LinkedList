public class PrintLLRecursive{
    public static void printRec(Node<Integer>){
        // Base case - Linked list is empty
        if(head == null){
            return;
        }
        System.out.println(head.data + " ");
        printRec(head.next);
    }

    public static void printRevRec(Node<Integer>){
        if(head == null){
            return;
        }
        printRevRec(head.next);
        System.out.print(head.data + " ");
    }
}