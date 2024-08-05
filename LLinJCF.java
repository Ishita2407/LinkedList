import java.util.LinkedList;
// USING JAVA COLLECTION FRAMEWORK TO IMPLEMENT LL
// All fns r optimized with good time complexity 
public class LLinJCF{
    public static void main(String args[]){
        // create -(objects int, float boolean) can't be used instead use Integer, Float , Character
        // This is actually a doubly linked list
        LinkedList<Integer> ll = new LinkedList<>();

        // add
        ll.addLast(1);
        ll.addLast(2);
        ll.addFirst(0);
        ll.add(20);  // adds to the end of the list

        // 0 -> 1 -> 2
        System.out.println(ll);


        ll.get(0);  // .get(index) --> to return value at an index
        ll.size();  // returns size of linkedlist


        // Traversing through linked list
        for(int i=0; i<ll.size(); i++){
            System.out.println(ll.get(i));
        }

        ll.set(0, 2);  // to replace value at an index
        ll.remove(); // removes first element by default 
        
        // remove
        ll.removeLast();
        ll.removeFirst();
        System.out.println(ll);
    }
}