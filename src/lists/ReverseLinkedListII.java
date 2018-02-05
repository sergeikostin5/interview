package lists;

/**
 * Created by sergei.kostin on 1/17/18.
 */
public class ReverseLinkedListII {




    public static void main(String[] args) {
        ReverseLinkedList rl = new ReverseLinkedList();
        LinkedListImpl ll = new LinkedListImpl();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);
        ll.printList(ll.getRoot());
        LinkedListImpl.ListNode node = rl.reverse(ll.getRoot());
        System.out.println();
        System.out.println(node);
        ll.printList(node);
    }

}
